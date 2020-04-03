package com.zhonghao.retrofitconvert;

import com.google.gson.Gson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * @author HZH
 * Create time : 2020/4/3
 * Explain :
 */
public class MyRetrofit {


    public <T> T create(Class<T> clazz){

        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[] { clazz },
                new InvocationHandler() {

                    @Override public Object invoke(Object proxy, Method method,  Object[] args)
                            throws Throwable {
                        //此处省略adapter的步骤
                        ParameterizedType parameterizedType = (ParameterizedType) method.getGenericReturnType();
                        Type returnType = Utils.getParameterUpperBound(0,parameterizedType);
                        Gson gson = new Gson();
                        T user = gson.fromJson((String)args[0],returnType);
                        Call<T> call = new Call<>(user);
                        return call;
                    }
                });
    }

}

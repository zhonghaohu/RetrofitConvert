package com.zhonghao.retrofitconvert;

/**
 * @author HZH
 * Create time : 2020/4/3
 * Explain :
 */
public class Call<T> {

    private T user;
    Call(T user){
        this.user = user;
    }

    public void enqueue(Callback<T> callback){
        callback.onSuccess(user);
    }
}

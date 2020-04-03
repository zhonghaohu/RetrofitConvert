package com.zhonghao.retrofitconvert;

/**
 * @author HZH
 * Create time : 2020/4/3
 * Explain :
 */
public interface TestService {

    Call<User> getUser(String name);
}

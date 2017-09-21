package com.example.hzcj.mymvptestdemo.model;

/**
 * Created by HZCJ on 2017/9/20.
 * <pre>
 * author:zhu
 * e-mail:18911664778@163.com
 * desc:
 * version:
 * </pre>
 */

public interface IUserModel {
    void login(String username,String password,onLoginListener loginListener);
}

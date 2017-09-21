package com.example.hzcj.mymvptestdemo.model;

import com.example.hzcj.mymvptestdemo.bean.User;

/**
 * Created by HZCJ on 2017/9/20.
 * <pre>
 * author:zhu
 * e-mail:18911664778@163.com
 * desc:
 * version:
 * </pre>
 */

public interface onLoginListener {
    void loginSucess(User user);
    void loginFailed();
}

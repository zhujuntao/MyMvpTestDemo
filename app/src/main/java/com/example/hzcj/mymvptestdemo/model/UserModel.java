package com.example.hzcj.mymvptestdemo.model;


import android.os.Handler;

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

public class UserModel implements IUserModel {

    @Override
    public void login(final String username, final String password, final onLoginListener loginListener) {
        //处理登录请求业务
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if("zhu".equals(username)&&"123".equals(password)){
                    //用户名及密码对了就做成功的相关业务
                    User user=new User();
                    user.setUserName(username);
                    user.setPassWord(password);
                    loginListener.loginSucess(user);
                }else {
                    loginListener.loginFailed();
                }

            }
        }.start();


    }
}

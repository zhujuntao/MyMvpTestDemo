package com.example.hzcj.mymvptestdemo.presenter;

import android.os.Handler;

import com.example.hzcj.mymvptestdemo.bean.User;
import com.example.hzcj.mymvptestdemo.model.IUserModel;
import com.example.hzcj.mymvptestdemo.model.UserModel;
import com.example.hzcj.mymvptestdemo.model.onLoginListener;
import com.example.hzcj.mymvptestdemo.view.UserLoginView;


/**
 * Created by HZCJ on 2017/9/20.
 * <pre>
 * author:zhu
 * e-mail:18911664778@163.com
 * desc:
 * version:
 * </pre>
 */

public class UserPresenter {
    private UserLoginView userLoginView;
    private IUserModel userModel;
    private Handler   handler=new Handler();

    public UserPresenter(UserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userModel=new UserModel();
    }
    public  void login(){
        userLoginView.showLoading();
        userModel.login(userLoginView.getUserName(), userLoginView.getPassWord(), new onLoginListener() {
            @Override
            public void loginSucess(final User user) {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }
    public void clear(){
        userLoginView.clearUserName();
        userLoginView.clearPassWord();
    }
}

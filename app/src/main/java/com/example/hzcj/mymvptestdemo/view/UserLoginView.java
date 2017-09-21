package com.example.hzcj.mymvptestdemo.view;

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

public interface UserLoginView {
    String getUserName();
    String getPassWord();
    void  clearUserName();
    void  clearPassWord();
    void  showLoading();
    void  hideLoading();
    void  toMainActivity(User user);
    void  showFailedError();

}

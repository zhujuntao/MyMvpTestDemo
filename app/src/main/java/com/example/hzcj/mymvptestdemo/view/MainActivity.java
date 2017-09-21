package com.example.hzcj.mymvptestdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hzcj.mymvptestdemo.R;
import com.example.hzcj.mymvptestdemo.bean.User;
import com.example.hzcj.mymvptestdemo.presenter.UserPresenter;

public class MainActivity extends AppCompatActivity implements UserLoginView{
    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;
    private UserPresenter userPresenter=new UserPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtUsername = (EditText) findViewById(R.id.et_userName);
        mEtPassword = (EditText) findViewById(R.id.et_passWord);
        mBtnClear = (Button) findViewById(R.id.bt_clear);
        mBtnLogin = (Button) findViewById(R.id.bt_login);
        mPbLoading = (ProgressBar) findViewById(R.id.lg_progress);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPresenter.login();
            }
        });
        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassWord() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassWord() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(MainActivity.this,"用户名："+user.getUserName()+"密码："+user.getPassWord()+"登录成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(MainActivity.this,"用户登录失败请检查登录账户！",Toast.LENGTH_SHORT).show();
    }
}

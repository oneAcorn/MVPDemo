package com.acorn.mvpdemo.login;

/**
 * Created by acorn on 2020/3/30.
 */
public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void login() {
        if ("admin".equals(mView.getUserName()) && "123".equals(mView.getPassword())) {
            mView.loginSuccess();
        }else{
            mView.loginFail("用户名或密码错误");
        }
    }

    @Override
    public void reset() {
        mView.resetEditView();
    }

    @Override
    public void start() {

    }
}

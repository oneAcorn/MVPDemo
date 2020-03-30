package com.acorn.mvpdemo.login;

import com.acorn.mvpdemo.BasePresenter;
import com.acorn.mvpdemo.BaseView;

/**
 * Created by acorn on 2020/3/30.
 */
public interface LoginContract {
    interface Presenter extends BasePresenter {
        void login();

        void reset();
    }

    interface View extends BaseView<Presenter> {
        String getUserName();

        String getPassword();

        void loginSuccess();

        void loginFail(String err);

        void resetEditView();
    }
}

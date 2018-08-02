package com.caliber.mvpbykshitin.login;

/**
 * Created by Caliber on 12-05-2018.
 */
// interactor == model
    // whole business logics will be HERE  and its implementation class only
public interface LoginInteractor {
    interface  onLoginFinishedListener{
        void onUserNameError();
        void onPasswordError();
        void onSuccess();
        void onFailure(String msg);
    }
    void login(String userName, String password, onLoginFinishedListener listener);
}

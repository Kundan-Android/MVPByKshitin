package com.caliber.mvpbykshitin.login;

/**
 * Created by Caliber on 12-05-2018.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUserNameError();
    void setPasswordError();
    void navigatetoMain();
    void showAlert(String msg);
}

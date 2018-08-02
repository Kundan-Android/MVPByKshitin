package com.caliber.mvpbykshitin.login;

/**
 * Created by Caliber on 12-05-2018.
 */

public interface LoginPresenter {
    void validateCred(String userName, String password);
    void onDestroy();

}

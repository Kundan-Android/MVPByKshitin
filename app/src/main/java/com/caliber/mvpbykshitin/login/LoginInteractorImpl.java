package com.caliber.mvpbykshitin.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Caliber on 12-05-2018.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(String userName, String password, final onLoginFinishedListener listener) {
        if (TextUtils.isEmpty(userName))
            listener.onUserNameError();
        else if (TextUtils.isEmpty(password))
            listener.onPasswordError();
        else if (userName.equals("admin") && (password.equals("12345"))){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.onSuccess();
                }
            }, 3000);

        }
        else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.onFailure("Invalid Credentials");
                }
            }, 3000);

        }

    }
}

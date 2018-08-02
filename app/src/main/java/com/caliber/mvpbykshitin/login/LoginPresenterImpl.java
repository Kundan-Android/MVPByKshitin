package com.caliber.mvpbykshitin.login;

/**
 * Created by Caliber on 12-05-2018.
 */

public class LoginPresenterImpl implements LoginPresenter , LoginInteractor.onLoginFinishedListener {
    LoginView mLoginView;
    LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCred(String userName, String password) {
        if (mLoginView != null){
            mLoginView.showProgress();
            mLoginInteractor.login(userName,password,this);
        }
    }

    @Override
    public void onDestroy() {
        if (mLoginView != null){
            mLoginView = null;
        }
    }

    @Override
    public void onUserNameError() {
        if (mLoginView != null){
           mLoginView.hideProgress();
           mLoginView.setUserNameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (mLoginView != null){
            mLoginView.hideProgress();
            mLoginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView != null){
            mLoginView.navigatetoMain();
        }
    }

    @Override
    public void onFailure(String msg) {
        if (mLoginView != null){
            mLoginView.hideProgress();
            mLoginView.showAlert(msg);
        }
    }
}

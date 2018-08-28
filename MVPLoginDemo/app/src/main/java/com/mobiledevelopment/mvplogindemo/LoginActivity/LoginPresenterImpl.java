package com.mobiledevelopment.mvplogindemo.LoginActivity;

/**
 * The LoginPresenterImpl class is the presenter class which communicates between the view and
 * the model. This class implements ({@link LoginPresenter}) with which the view communicate with
 * the presenter and the ({@link LoginInteractor.OnLoginListener}) from which the model
 * communicates with the presenter.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void checkUsernameAndPassword(String username, String password) {
        if (loginView != null) {
            loginView.showProgressBar();
            loginInteractor.checkLoginData(username, password, this);
        }
    }

    @Override
    public void onDestrtoy() {
        loginView = null;
    }

    @Override
    public void onUsernameError(String message) {
        if (loginView != null) {
            loginView.hideProgressBar();
            loginView.showUsernameError(message);
        }
    }

    @Override
    public void onPasswordError(String message) {
        if (loginView != null) {
            loginView.hideProgressBar();
            loginView.showPasswordError(message);
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.hideProgressBar();
            loginView.goToNextActivity();
        }
    }
}

package com.mobiledevelopment.mvplogindemo.LoginActivity;

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

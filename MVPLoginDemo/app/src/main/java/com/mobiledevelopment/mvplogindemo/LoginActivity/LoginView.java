package com.mobiledevelopment.mvplogindemo.LoginActivity;

public interface LoginView {
    void showProgressBar();

    void hideProgressBar();

    void goToNextActivity();

    void showUsernameError(String message);

    void showPasswordError(String message);
}

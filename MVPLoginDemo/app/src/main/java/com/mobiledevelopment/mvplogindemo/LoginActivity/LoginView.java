package com.mobiledevelopment.mvplogindemo.LoginActivity;

/**
 * Used by the presenter to communicate with the view
 **/
public interface LoginView {
    void showProgressBar();

    void hideProgressBar();

    void goToNextActivity();

    void showUsernameError(String message);

    void showPasswordError(String message);
}

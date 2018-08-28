package com.mobiledevelopment.mvplogindemo.LoginActivity;

/**
 * Used by the view to communicate with the presenter. Depending on the functions called by the view,
 * the presenter will communicate with the model and get the results.
 */
public interface LoginPresenter {
    void checkUsernameAndPassword(String username, String password);

    void onDestrtoy();
}

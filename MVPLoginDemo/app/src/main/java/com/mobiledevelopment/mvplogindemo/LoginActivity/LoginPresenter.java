package com.mobiledevelopment.mvplogindemo.LoginActivity;

public interface LoginPresenter {
    void checkUsernameAndPassword(String username, String password);

    void onDestrtoy();
}

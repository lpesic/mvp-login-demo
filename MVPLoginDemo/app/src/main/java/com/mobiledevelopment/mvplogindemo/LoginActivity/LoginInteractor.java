package com.mobiledevelopment.mvplogindemo.LoginActivity;

public interface LoginInteractor {
    interface OnLoginListener {
        void onUsernameError(String message);

        void onPasswordError(String message);

        void onSuccess();
    }

    void checkLoginData(String username, String password, OnLoginListener listener);
}

package com.mobiledevelopment.mvplogindemo.LoginActivity;

import android.os.Handler;

import com.mobiledevelopment.mvplogindemo.Utils.CommonFunctions;

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void checkLoginData(String username, String password, OnLoginListener listener) {
        new Handler().postDelayed(() -> {
            if (!CommonFunctions.checkNull(username)) {
                listener.onUsernameError("Check username and try again");
                return;
            }
            if (!CommonFunctions.checkNull(password)) {
                listener.onPasswordError("Check password and try again");
                return;
            }
            listener.onSuccess();
        }, 2000);
    }
}

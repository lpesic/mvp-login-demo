package com.mobiledevelopment.mvplogindemo.LoginActivity;

import android.content.Intent;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.mobiledevelopment.mvplogindemo.Data.ApplicationData;
import com.mobiledevelopment.mvplogindemo.MainActivity.MainActivity;
import com.mobiledevelopment.mvplogindemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    @BindView(R.id.et_login_activity_username) EditText username;
    @BindView(R.id.et_login_activity_password) EditText password;
    @BindView(R.id.btn_login_activity_login) Button login;
    @BindView(R.id.pb_login_activity_progress) ProgressBar progressBar;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        login.setOnClickListener(this);
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestrtoy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.equals(login)) {
            loginPresenter.checkUsernameAndPassword(username.getText().toString(),
                    password.getText().toString());
        } else {
            Log.e(ApplicationData.TAG, getString(R.string.unknown_view));
        }
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void goToNextActivity() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    @Override
    public void showUsernameError(String message) {
        Snackbar.make(login, message, BaseTransientBottomBar.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordError(String message) {
        Snackbar.make(login, message, BaseTransientBottomBar.LENGTH_SHORT).show();
    }
}

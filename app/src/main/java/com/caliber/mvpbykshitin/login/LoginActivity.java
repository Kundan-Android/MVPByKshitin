package com.caliber.mvpbykshitin.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.caliber.mvpbykshitin.MainActivity;
import com.caliber.mvpbykshitin.R;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private EditText edUserName, edPassword;
    private Button btnDone;
    private ProgressBar pbLoad;
    private LoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserName = findViewById(R.id.ed_user_name);
        edPassword = findViewById(R.id.ed_password);
        btnDone = findViewById(R.id.bt_done);
        pbLoad = findViewById(R.id.progressBar);
        mLoginPresenter = new LoginPresenterImpl(this);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.validateCred(edUserName.getText().toString().trim(),edPassword.getText().toString().trim());
            }
        });
    }

    @Override
    public void showProgress() {
        pbLoad.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoad.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        edUserName.setError("UserName Empty");
    }

    @Override
    public void setPasswordError() {
        edPassword.setError("Password Empty");
    }

    @Override
    public void navigatetoMain() {
        Intent in = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(in);
    }

    @Override
    public void showAlert(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }
}

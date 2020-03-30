package com.acorn.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.acorn.mvpdemo.login.LoginContract;
import com.acorn.mvpdemo.login.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginContract.View {
    private LoginContract.Presenter mPresenter;
    private EditText userNameEt, pwdEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEt = findViewById(R.id.userNameEt);
        pwdEt = findViewById(R.id.pwdEt);

        new LoginPresenter(this);

        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login();
            }
        });

        findViewById(R.id.resetBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.reset();
            }
        });
    }

    @Override
    public String getUserName() {
        return userNameEt.getText().toString();
    }

    @Override
    public String getPassword() {
        return pwdEt.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "成功了", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFail(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }

    @Override
    public void resetEditView() {
        userNameEt.setText(null);
        pwdEt.setText(null);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}

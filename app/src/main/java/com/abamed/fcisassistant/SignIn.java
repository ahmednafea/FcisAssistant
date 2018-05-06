package com.abamed.fcisassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {
    protected EditText emailtext;
    protected EditText passwordtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailtext= (EditText) findViewById(R.id.emailbox);
        passwordtext = (EditText) findViewById(R.id.passwordbox);
    }
    public void check(View view)
    {
        Intent intent =new Intent(SignIn.this ,StudentNavigation.class);
        SignIn.this.finish();
        startActivity(intent);
    }
}

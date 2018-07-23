package com.example.shiz.livetracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText name,email,password,Mobile;
    Button signup,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPref session = new SharedPref(MainActivity.this);
        name = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        Mobile = (EditText) findViewById(R.id.mobile);
        login=(Button)findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString().trim();
                String userpassword = password.getText().toString().trim();
                String useremail = email.getText().toString().trim();
                String mobile = Mobile.getText().toString().trim();
                if (username.isEmpty() || userpassword.isEmpty() || useremail.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    session.storeUser(username, userpassword, useremail, mobile);
                    Intent in = new Intent(MainActivity.this, Login.class);
                    startActivity(in);
                    finish();
                    Toast.makeText(MainActivity.this, "Successfully Registered please Sign in", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Login.class);
                startActivity(in);
                finish();
            }
        });

    }
}

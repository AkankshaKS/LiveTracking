package com.example.shiz.livetracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText loginname,loginpassword;
    Button login;
    SharedPref session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        session=new SharedPref(Login.this);
        loginname=(EditText)findViewById(R.id.loginusername);
        loginpassword=(EditText)findViewById(R.id.loginpassword);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=loginname.getText().toString().trim();
                String pass=loginpassword.getText().toString().trim();
                if(name.isEmpty()||pass.isEmpty())
                {
                    Toast.makeText(Login.this, "Please Fill the details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    invalidateUser(name,pass);
                }
            }
        });
        setValuesFromSignUp();
    }
    public void setValuesFromSignUp()
    {
        loginname.setText(session.getUserName().equalsIgnoreCase("")?"":session.getUserName());
        loginpassword.setText(session.getUserPassword().equalsIgnoreCase("")?"":session.getUserPassword());
    }
    public void invalidateUser(String name,String pass)
    {
        if(name.equalsIgnoreCase(session.getUserName()) && pass.equalsIgnoreCase(session.getUserPassword()))
        {
            session.loginUser(name,pass,true);
            Intent in=new Intent(Login.this,MapsActivity.class);
            startActivity(in);
            finish();
        }
        else
        {
            Toast.makeText(Login.this, "Wrong Username or Password! Try again", Toast.LENGTH_SHORT).show();
        }
    }
}
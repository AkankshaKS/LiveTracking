package com.example.shiz.livetracking;

import android.content.Context;
import android.content.SharedPreferences;



public class SharedPref {
    //key for username
    private String USERNAME="username";
    //key for password
    private String PASSWORD="password";
    //key for email
    private String EMAIL="email";
    //key for preferences
    private String MOBILE="mobile";

    private String PREFERENCES="spfpref";
    //key for is user login
    private String ISLOGIN="login";
    // Shared Preferences variable
    SharedPreferences spfprefer;
    //editor for shared preference
    SharedPreferences.Editor editor;
    public SharedPref(Context context)
    {
        spfprefer=context.getSharedPreferences(PREFERENCES,Context.MODE_PRIVATE);
        editor=spfprefer.edit();
    }
    // function store user details
    public void storeUser(String name,String pass,String email,String mobile)
    {
        editor.putString(USERNAME,name);
        editor.putString(PASSWORD,pass);
        editor.putString(EMAIL,email);
        editor.putString(MOBILE,mobile);
        editor.commit();
    }
    // to login user
    public void loginUser(String name,String password,boolean login)
    {
        editor.putString(USERNAME,name);
        editor.putString(PASSWORD,password);
        editor.putBoolean(ISLOGIN,login);
        editor.commit();
    }
    //to get username
    public String getUserName()
    {
        return spfprefer.getString(USERNAME,"");
    }
    //to get userpassword
    public String getUserPassword()
    {
        return spfprefer.getString(PASSWORD,"");
    }
    public String geuserMobile()
    {
        return spfprefer.getString(MOBILE,"");
    }


    //to get useremail
    public String getUserEmail()
    {
        return spfprefer.getString(EMAIL,"");
    }
    //to check whether user is login or not
    public boolean isUserLogedIn()
    {
        return spfprefer.getBoolean(ISLOGIN,false);
    }
    // to delete the user and clear the preferences
    public void logOutUser()
    {
        editor.clear();
        editor.commit();
    }


}

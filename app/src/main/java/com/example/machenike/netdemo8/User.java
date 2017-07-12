package com.example.machenike.netdemo8;

/**
 * Created by MACHENIKE on 2017/7/11.
 */

public class User {

    /**
     * Password : 654321
     * UserName : qjd
     */

    private String Password;
    private String UserName;
    public User(String Password,String UserName){
        this.Password = Password;
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
}

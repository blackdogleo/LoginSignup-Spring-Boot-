package com.zetcode.demo.mybean;

public class LogUser {
    public String uname ;
    public String upass ;


    public String getName() {
        return uname;
    }

    public String getPass() {
        return upass;
    }

    public String setName(String name){

        uname=name;
        return "";
    }
    public String setPass(String pass){

        upass=pass;
        return "";
    }






}

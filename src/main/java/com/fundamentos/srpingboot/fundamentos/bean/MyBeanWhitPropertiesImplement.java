package com.fundamentos.srpingboot.fundamentos.bean;

public class MyBeanWhitPropertiesImplement implements  MyBeanWhitProperties{
    private  String name;
    private  String lastname;
    private  String random;

    public MyBeanWhitPropertiesImplement(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.random = random;
    }

    @Override
    public String function() {
        return name + "-"+ lastname;
    }
}

package com.learncamel.bean;

import org.apache.camel.Body;

public class CamelBean {
    public String map(String input){
        String newBody = input.replace(",","*");
        return newBody;

    }
    public String map1(String input){
        String newBody = input.replace(",","*");
        return newBody;

    }
}

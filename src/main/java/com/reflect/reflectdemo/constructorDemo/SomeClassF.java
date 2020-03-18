package com.reflect.reflectdemo.constructorDemo;

public class SomeClassF {
    private int num;
    private String str;

    public SomeClassF(){
        this.num = 10;
        this.str = "song";
    }
    public SomeClassF(int num){
        this.num = num;
    }

    public SomeClassF(int num,String str){
        this.num = num;
        this.str = str;
    }

    public void printNum(){
        System.out.println(this.num);
    }

    public void printStr(){
        System.out.println(this.str);
    }
}

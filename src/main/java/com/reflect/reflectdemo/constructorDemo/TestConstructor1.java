package com.reflect.reflectdemo.constructorDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestConstructor1 {

    public static void main(String[] args) {
        SomeClassF sf = new SomeClassF();
        Class cfInstance = sf.getClass();

        Constructor[] cons = cfInstance.getConstructors();
        for(Constructor con:cons){
            try {
                //判定构造器参数大于0个
                if(con.getParameterCount()==1){
                    //有参构造函数 传入100
                    SomeClassF objF = (SomeClassF) con.newInstance(100);
                    //打印100
                    objF.printNum();
                    System.out.println("------");
                }else if(con.getParameterCount()==2){
                    SomeClassF objF = (SomeClassF) con.newInstance(99, "ninety-nine");
                    objF.printNum();
                    objF.printStr();;
                    System.out.println("------");
                }else if(con.getParameterCount()==0){
                    //无参构造函数
                    SomeClassF objF = (SomeClassF) con.newInstance();
                    objF.printNum();
                    System.out.println("------");
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}

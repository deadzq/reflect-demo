package com.reflect.reflectdemo.fatherClassInterfaceDemo;

import java.lang.reflect.Field;

public class TestFatherAndSon {
    public static void main(String[] args) {
        SomeSon son = new SomeSon();
        Class sonClass = son.getClass();

        //获取父类
        Class fatherClass = sonClass.getSuperclass();
        System.out.println("father className:"+fatherClass.getName());

        Class[] inters = sonClass.getInterfaces();
        for(Class inter:inters){
            System.out.println("son's interface:"+inter.getName());
        }

        //同样father也可以
        SomeFather father = new SomeFather();
        Class fatherClassGet = father.getClass();
        System.out.println("father class name:"+fatherClassGet.getName());

        Class[] interfacesFather = fatherClassGet.getInterfaces();
        for(Class inter:interfacesFather){
            System.out.println("father's interface:"+inter.getName());
            Field[] declaredFields = inter.getDeclaredFields();
            for(Field f:declaredFields){
                System.out.println("father's interface's name:"+f.getName());
            }

        }

    }
}

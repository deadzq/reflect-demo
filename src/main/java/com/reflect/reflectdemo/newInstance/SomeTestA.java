package com.reflect.reflectdemo.newInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SomeTestA {

    public static void main(String[] args) {
        try {
            //newInstance 调用构造函数
            Object someTestA = Class.forName("com.reflect.reflectdemo.newInstance.SomeTestA").newInstance();
            //获取forName的类中名hello方法的句柄
            Method m = Class.forName("com.reflect.reflectdemo.newInstance.SomeTestA").getMethod("hello");
            //在someTestA调用方法
            m.invoke(someTestA);

            SomeTestA o = (SomeTestA)Class.forName("com.reflect.reflectdemo.newInstance.SomeTestA").newInstance();

            Constructor<SomeTestA> constructor = SomeTestA.class.getConstructor();
            SomeTestA someTestA1 = constructor.newInstance();
            someTestA1.hello();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
        }
    }

    //将被调用
    public void hello(){
        System.out.println("hello world!");
    }
}

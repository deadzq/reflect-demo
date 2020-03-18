package com.reflect.reflectdemo.cloneObj;

public class SomeClassA implements Cloneable{
    public void hello(){
        System.out.println("hello from SomeClassA");
    }
    @Override
    protected Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String[] args) {
        SomeClassA ca = new SomeClassA();
        ca.hello();
        try {
            //进行copy及类型强转换
            SomeClassA caCopy = (SomeClassA) ca.clone();
            caCopy.hello();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}

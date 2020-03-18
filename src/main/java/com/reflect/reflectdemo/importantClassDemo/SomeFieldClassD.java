package com.reflect.reflectdemo.importantClassDemo;

import java.lang.reflect.Field;

/**
 * 获取Field成员变量
 */
public class SomeFieldClassD {

    public static void main(String[] args) {
        SomeFieldClassD someD = new SomeFieldClassD(20,"Some people hear their own inner voices with great clearness.");
        Class aClassD = someD.getClass();

        try {
            //获取本类及父类所有的public字段
            Field[] fields = aClassD.getFields();
            for(int i=0;i<fields.length;i++){
                System.out.println(fields[i].getName()+":"+fields[i].get(someD));
            }
            System.out.println("---------------♥---------------");
            //获取本类所有声明的字段
            Field[] declaredFields = aClassD.getDeclaredFields();
            for(Field fd:declaredFields){
                fd.setAccessible(true);
                System.out.println(fd.getName()+":"+fd.get(someD));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public int valueInt;
    private String valueStr;

    public SomeFieldClassD(int valueInt, String valueStr){
       this.valueInt = valueInt;
       this.valueStr = valueStr;
    }

}

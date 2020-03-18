package com.reflect.reflectdemo.importantClassDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 获取Method成员方法
 */
public class SomeMethodClassE {

    public static void main(String[] args) {
        SomeMethodClassE clazzE = new SomeMethodClassE();
        Class clazzEInstance = clazzE.getClass();

        String s = new String();
        Class strClass = s.getClass();

        try {
            //获取public方法 包括父类和父接口
            Method[] ms = clazzEInstance.getMethods();
            for(Method m:ms){
                if("f1".equals(m.getName())){
                    m.invoke(clazzE,null);
                }
            }

            Method[] strMs = strClass.getMethods();
            for(Method m:strMs){
                if("hashCode".equals(m.getName())){
                    int hashCode1 = (int)m.invoke("hello will be hashed", null);
                    int hashCode2 = (int)m.invoke("world will be hashed", null);
                    int hashCode3 = (int)m.invoke("time will be hashed", null);
//                    Integer example4 = 111111;
                    //java.lang.IllegalArgumentException: object is not an instance of declaring class
//                    int hashCode4 = (int)m.invoke(example4, null);
                    System.out.println("hash1:"+hashCode1);
                    System.out.println("hash2:"+hashCode2);
                    System.out.println("hash3:"+hashCode3);
                }
                if("toString".equals(m.getName())){
                    String str = (String)m.invoke("My name is someOne .", null);
                    System.out.println(str);
                }

            }

            //获取该类的所有方法
            Method[] msDeclared = clazzEInstance.getDeclaredMethods();
            for(Method m:msDeclared){
                //获取名字为f2的方法
                if("f2".equals(m.getName())){
                    m.setAccessible(true);
                    //Exception in thread "main" java.lang.IllegalArgumentException: wrong number of arguments
//                    String someNullText = (String) m.invoke(clazzE, null);
//                    System.out.println(someNullText);
                    String someText = (String)m.invoke(clazzE, "someText");
                    System.out.println(someText);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void f1() {
        System.out.println("f1()...");
    }

    private String f2(String s) {
        System.out.println("f2()...");
        return s;
    }
}

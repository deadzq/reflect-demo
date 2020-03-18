package com.reflect.reflectdemo.serializationObj;

import java.io.*;

public class SomeClassC implements Serializable {

    private static final long serialVersionUID = 1L;

    public void hello(){
        System.out.println("hello from SomeClassC");
    }

    public static void main(String[] args) {
        //序列化,没有调用构造函数
        //序列化会引发安全漏洞,未来将被移除JDK,请谨慎使用!!
        SomeClassC c = new SomeClassC();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
            //写对象
            out.writeObject(c);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
            //读对象
            SomeClassC copyC = (SomeClassC) in.readObject();
            in.close();
            //这里输出了原始类方法的输出语句
            copyC.hello();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }

    }
}

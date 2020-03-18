package com.reflect.reflectdemo;

import lombok.Data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 获取类的成员
 */
@Data
public class GetFieldsDemo {

    public static void main(String[] args) {
        GetFieldsDemo getFieldsDemo = new GetFieldsDemo();
        Class thisClazz = getFieldsDemo.getClass();
        Constructor[] constructors;
        /*
        通过getDeclaredConstructors可以返回类的所有构造方法,
        返回的是一个数组因为构造方法可能不止一个,
        通过getModifiers可以得到构造方法的类型,
        getParameterTypes可以得到构造方法的所有参数,
        返回的是一个Class数组,
        所以我们如果想获取所有构造方法以及每个构造方法的参数类型可以有如下代码
        */
        constructors = thisClazz.getDeclaredConstructors();
        for(int i=0;i<constructors.length;i++){
            System.out.print(Modifier.toString(constructors[i].getModifiers())+"参数:");
            Class[] parametertypes = constructors[i].getParameterTypes();
            for(int j=0;j<parametertypes.length;j++){
                System.out.print(parametertypes[j].getName()+" ");
            }
            System.out.println();
        }

        Class[] p = {int.class,String.class};

        try {
            Constructor declaredConstructor = thisClazz.getDeclaredConstructor(p);
            System.out.println(Modifier.toString(declaredConstructor.getModifiers())+"参数: ");
            Class[] parametertypes = declaredConstructor.getParameterTypes();
            for(int j=0;j<parametertypes.length;j++){
                System.out.println(parametertypes[j].getName()+" ");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
        }
    }

   private int someValue;
   private String someFiled;
   private int testInt;

   public GetFieldsDemo(int someValue){
       this.someValue = someValue;
   }

   public GetFieldsDemo(int someValue,String someFiled){
       this.someValue = someValue;
       this.someFiled = someFiled;
   }

   private GetFieldsDemo(String someFiled){
       this.someFiled = someFiled;
   }

   public GetFieldsDemo(){
   }
}

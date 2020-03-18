package com.reflect.reflectdemo;

/**
 * 获取类对象
 */
public class GetClassDemo {

    public static void main(String[] args) {
        String name = "helloworld";
        Class c1 = name.getClass();
        //输出 java.lang.String 说明哈喽world是所属字符串类
        System.out.println("c1:"+c1.getName());

        String clazzName = "java.lang.String";
        Class c2 = null;
        try {
            c2 = Class.forName(clazzName);
            //同样输出 java.lang.String
            System.out.println("c2:"+c2.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }

        String clazzNameError = "java.notthisclass.error";
        Class c3ErrorMaybe = null;
        try {
            c3ErrorMaybe = Class.forName(clazzNameError);
            //这里用Exception更恰当,error只是作者说明会出异常/错误
            System.out.println("c3:"+c3ErrorMaybe.getName());
        } catch (ClassNotFoundException e) {
            //进行了异常抓取,因为并没有"java.notthisclass.error"的实际类库
//            e.printStackTrace();
        } finally {
        }

        System.out.println("----------------------");

        Class<Boolean> clz1 = Boolean.TYPE;
        Class<Byte> clz2 = Byte.TYPE;
        Class<Float> clz3 = Float.TYPE;
        Class<Double> clz4 = Double.TYPE;
        //boolean
        System.out.println(clz1);
        //byte
        System.out.println(clz2);
        //float
        System.out.println(clz3);
        //double
        System.out.println(clz4);



    }
}

package com.reflect.reflectdemo.dynamicArray;

import java.lang.reflect.Array;

public class DynamicArrayDemo {

    public static void main(String[] args) {
        int[] aArr = {1,2,3,4,5};
        System.out.println("oldArray length:"+aArr.length);
        aArr = (int[]) goodCopy(aArr,10);
        System.out.println("newArray length:"+aArr.length);
        for(int i:aArr){
            System.out.print(i+" ");
        }
    }

    //进行数组扩充
    public static Object goodCopy(Object oldArray,int newLength){
        //Array类型
        Class oldArrayClass = oldArray.getClass();

        //获取数组中的单个元素类型
        Class componentType = oldArrayClass.getComponentType();

        //旧数组长度
        int oldLength = Array.getLength(oldArray);

        //新数组
        Object newArray = Array.newInstance(componentType, newLength);

        //拷贝旧数据 oldArray->newArray
        System.arraycopy(oldArray,0,newArray,0,oldLength);
        return newArray;
    }
}

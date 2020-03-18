package com.reflect.reflectdemo.fatherClassInterfaceDemo;

public class SomeSon extends SomeFather implements Cloneable,Comparable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

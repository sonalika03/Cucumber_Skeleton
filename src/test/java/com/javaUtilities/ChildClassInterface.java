package com.javaUtilities;

public class ChildClassInterface implements PInterface{

    @Override
    public void method1() {
        System.out.println("Implemeted method1");
    }

    @Override
    public void method2() {
        System.out.println("Implemented method2");
    }

    public static void main(String[] args){
        PInterface cc = new ChildClassInterface();
        // ChildClassI cc = new ChildClassI();
        cc.method1();
        cc.method2();
    }
}

package com.javaUtilities;

public class ChildClassAbstract extends AbstractionA{

    @Override
    public void method2() {
        System.out.println("Abstract method");
    }
    public void method1(){
        System.out.println("Non-Abstract method in child class");
    }
    public static void main(String[] args){
        AbstractionA a = new ChildClassAbstract();
        a.method2();
        a.method1();
    }
}

package com.javaUtilities;

public class ChildClassInherit extends InheritanceA{
    public void finalmethod(){
        methodA();
        methodB();
    }
    public void methodA(){
        System.out.println("Child class method A");
    }

    public static void main(String[] args){
        ChildClassInherit a = new ChildClassInherit();
        a.methodA();
        a.finalmethod();
    }

}

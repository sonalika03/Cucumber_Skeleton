package com.javaUtilities;

import java.util.*;

public class StackClass {

    public static void main(String args[]){

        Stack<String> unoCards = new Stack<>();   //LastInFirstOut
        unoCards.push("YellowNine");   //adds elements to the stack
        unoCards.push("BlueNine");
        unoCards.push("BlueReverse");
        unoCards.push("RedReverse");

        System.out.println(unoCards);

        System.out.println(unoCards.peek());   //shows the element which is on the top of the stack

        unoCards.pop();         //removes the element which is on the top of stack
        System.out.println(unoCards);

    }
}

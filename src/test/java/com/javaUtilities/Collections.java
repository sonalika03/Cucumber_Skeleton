package com.javaUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Collections {
    public static void main(String[] args){
        Collections collections = new Collections();
        collections.ListInterface();
    }
    public void ListInterface(){
        //Arraylist  Vector
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.addAll(Arrays.asList("one", "Four"));
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.size());
        arrayList.remove("one");
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(1));

        //LinkedList
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.addAll(Arrays.asList(1,3,5));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.size());
        linkedList.remove(1);
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.size());
        System.out.println(linkedList.get(1));
    }
    public void SetInterface(){


    }
}

package com.javaUtilities;

import java.util.ArrayList;
import java.util.Arrays;

public class JavaBasics {

    public static void main(String[] args){
        JavaBasics bs = new JavaBasics();
        bs.replaceSpaces();
    }

    public void reverseArray(){
        // reversing an array
        int[] arr = {10, 2, 3, 13, 8};
        int[] b = new int[arr.length];
        int n = arr.length; //length of arr
        for (int i=0;i< arr.length;i++){
            b[n-1] = arr[i];
            n=n-1;
        }
        for (int j=0; j< arr.length; j++){
            System.out.println(b[j]);
        }
    }
    public void reverseArrayList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(2,4,6,8));
        ArrayList<Integer> revList = new ArrayList<>();
        for (int i = list.size()-1; i>=0;i--){
            revList.add(list.get(i));
        }
        for (int j = 0; j< list.size();j++){
            System.out.println(revList.get(j));
        }
    }
    public void basics(){
        // "Michael Jackson" ---> "MichaelJackson"
        String s = "Michael Jackson";
        String[] s1 =s.split(" ");
        String s2 = s1[0]+s1[1];
        System.out.println(s + " is modified to "+s2);

        //Reverse a String "MichaelJackson" ---> "noskcaJleahciM"
        String temp = "";
        for (int i= s2.length()-1;i>=0;i--){
            temp = temp + s2.charAt(i);
        }
        System.out.println(s2 +" is reversed to "+temp);

        //use of trim -- removes white spaces
        String t = " Sony";
        System.out.println(t + " is trimmed to " + t.trim());

        // reverse a number
        int n = 4567;
        int r = 0;
        System.out.print(n +" is reversed to ");
        while (n>0){
            r = r*10 + n%10;   // 0*10 + 4567%10(remainder) = 0+7 = 7 = r
            n = n/10;          // 4567/10(quotient) = 456
        }
        System.out.println(r);


        //swap two numbers using temporary variable
        int a = 2, b = 5, c;
        System.out.print(a + " and "+b+" are changed to " );
        c = a;
        a = b;
        b = c;
        System.out.println(a + " and "+b+ " by using temporary variable");

        // swap two numbers without using temporary variable
        a = a + b;  //7
        b = a - b;  //2
        a = a - b;  //5
        System.out.println("Changed back to "+a+ " and "+b+ " without using temporary variable");


        // while loop
        int ij = 0;
        while (ij>10) {
            System.out.println("While loop"+ij);
            ij++;
        }

        //do-while loop
        int ji = 0;
        do {
            System.out.println("Do-while loop : "+ji);
            ji++;
        }while (ji>10);

        //1 2 3 4
        //5 6 7
        //8 9
        //10
        int pyramid = 1;
        for (int p=0;p<4; p++){
            for (int q = 1; q<=4-p; q++){
                System.out.print(pyramid+ " ");
                pyramid++;
            }
            System.out.println();
        }

        //1
        //2 3
        //4 5 6
        //7 8 9 10
        int py = 1;
        for (int e=0; e<4; e++){
            for (int f=0; f<e+1; f++){
                System.out.print(py +"\t");
                py++;
            }
            System.out.println();
        }


        //3
        //6	9
        //12 15	18
        //21 24	27 30
        int pyr = 3;
        int k=1;
        for (int e=0; e<4; e++){
            for (int f=0; f<e+1; f++){
                int x = pyr*k;
                System.out.print(x +"\t");
                k++;
            }
            System.out.println();
        }


    }
    public void frequencyOfNumbers() {
        int arr[] = {2, 2, 3, 5, 4, 2, 3, 6};
        int arr2[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]&& arr[i]!=0) {
                    count++;
                    arr[j] = 0;
                }
            }
            if (arr[i]!=0){
                arr2[i] = count;}
        }
        for (int i = 0; i<arr.length;i++) {
            if (arr[i]!=0 && arr2[i]!=1){
            System.out.println("The frequency of " + arr[i]+ " is "+arr2[i]);}
        }
    }
    public void replaceSpaces() {
        String a = "Michael Jackson";
        String temper = "";
        for (int i = 0; i < a.length(); i++) {
            String temp = "";
           temp = temp + a.charAt(i);
           if (temp.equals(" ")){
               temp = "@";
               temper = temper + temp;
           }
           else
               temper = temper + temp;
           }
        System.out.println(temper);
        }
        //Streams api in java, ternary operator
    }
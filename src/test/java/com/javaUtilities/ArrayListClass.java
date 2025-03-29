package com.javaUtilities;

import java.io.FileNotFoundException;
import java.util.*;

public class ArrayListClass {

    public static void main(String args[]){

        //Array----------------------------------------------------------------
        String[] friends = new String[3];
        friends[0]="Bheem";
        friends[1]="Chutki";
        friends[2]="kaliya";
        System.out.println(friends[0]);
        System.out.println(friends[1]);
        System.out.println(friends[2]);
        for (int i=0;i< friends.length;i++) {
            System.out.println(friends[i]);
        }

        //ArrayList------------------------------------------------------------
        ArrayList<String> bestfriends = new ArrayList<>();
        bestfriends.add(0,"Dholu");
        bestfriends.add("Bholu");
        bestfriends.add("TunTunMausi");
        System.out.println(bestfriends); //1

        bestfriends.add(1, "raju");
        System.out.println(bestfriends);

        ArrayList<String> enemies = new ArrayList<>();
        enemies.add("kaaliya");
        enemies.add("bheem");
        enemies.add("Raju");
        bestfriends.addAll(enemies);
        System.out.println(bestfriends);  //2
        System.out.println(bestfriends.get(2));  //3
        bestfriends.set(4,"BHEEM");
        bestfriends.remove(5);
        System.out.println(bestfriends);  //4
        System.out.println(enemies.contains("Raju"));  //5
        System.out.println(enemies.contains("raju"));  //6
        System.out.println(enemies.contains("bheem"));  //7
       // bestfriends.clear();
        System.out.println(bestfriends);  //8

        for (String name : bestfriends){
            System.out.println(name);
        }
        Iterator<String> name = bestfriends.iterator();
        System.out.println(name.next());



        //Queue-----------------------------------------------------------------
        Queue<Integer> numbers = new PriorityQueue<>();

        // offer elements to the Queue
        numbers.offer(3);
        numbers.offer(5);
        numbers.offer(2);
        System.out.println("Queue: " + numbers);

        // Access elements of the Queue
        int accessedNumber = numbers.peek();
        System.out.println("Accessed Element: " + accessedNumber);

        // Remove elements from the Queue
        int removedNumber = numbers.poll();
        System.out.println("Removed Element: " + removedNumber);

        System.out.println("Updated Queue: " + numbers);

        //Map--------------------------------------------------------------------
        Map<String, Integer> values = new TreeMap<>();
        // Insert elements to map
        values.put("Fourth", 4);
        values.put("Third", 3);
        values.put("Second", 2);
        values.put("First", 1);
        System.out.println("Map using TreeMap: " + values);
    }
    }
package com.testngUtilities;

import org.testng.annotations.*;;

public class TestNGPractice {
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    @Test
    public void test(){
        System.out.println("test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
}

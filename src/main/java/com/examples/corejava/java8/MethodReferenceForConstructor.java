package com.examples.corejava.java8;

import lombok.Data;


//Step-1: Class that we want to instantiate using  MethodReference  i.e. MyDemoClass::new
@Data
class MyDemoClass{
    private int id;
    private String name;
    private boolean isActive;

    public MyDemoClass(){
        id = 999;
        name="dummy";
        isActive = true;
    }
}

//Step-2 : declare FI
@FunctionalInterface
interface MyDemoClassFunctionalIntf{
    MyDemoClass create();
}


public class MethodReferenceForConstructor {
    public static void main(String[] args) {
        //step-3: attach logic to Lambda
        MyDemoClassFunctionalIntf inst = MyDemoClass::new;

        //step-4 : invoke Lambda expression
        MyDemoClass obj = inst.create();
        System.out.println(obj.toString());
    }
}
package com.examples.corejava.java8;


//import java.util.function.Function<T, R>;
//    R apply(T t); <-- Method to be invoked

import java.util.Scanner;
import java.util.function.Function;

public class LambdaFunction01 {
    public static void main(String[] args) {

        //Function logic {Function is already @FunctionalInterface so no declaration step here)
        Function<Integer, String> checkEvenOdd = (i) -> {
            if(i % 2==0) return "even";
            else return "odd";
        };

        //Get user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to check odd/even:");
        String str1 = sc.nextLine();
        int intFromStr = Integer.parseInt(str1);
        String output = checkEvenOdd.apply(intFromStr);  // Calling apply() of Function


        //Function invocation
        System.out.println(str1 + " is " + output   + " number");
    }
}

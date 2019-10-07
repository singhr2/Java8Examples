package com.examples.corejava.java8;

import jdk.nashorn.internal.objects.annotations.Function;

import java.util.Scanner;

@FunctionalInterface
interface SquareCalculator{
    int calculateSquare(int input);
}

@FunctionalInterface
interface SqrtCalculator{
    Double calculateSqrt(int Double);
}

//part 1 of 3 : Declaration
@FunctionalInterface
interface AddNumbers{
    int sum(int n1, int n2);
}
public class Lambda03 {
    public static void main(String[] args) {
        SquareCalculator sc = (num) -> num*num;

        // get input from command line
        Scanner scanner= new Scanner(System.in);
        System.out.println("Please enter a number : ");
        String input = scanner.nextLine();

        int output = sc.calculateSquare(Integer.valueOf(input));
        System.out.println("Square of " + input + " is " + output);


        //---------- calling 2nd lambda -------------

        //part 2 of 3 : logic part
        AddNumbers add = (num1, num2) -> num1 + num2;

        //part 3 of 3 : invocation
        int result = add.sum(1, 2);
        System.out.println("> Sum is : " + result);

        // e.g., 3
        //3.1 :  declare FI (already done)
        //3.2 define logic for lambda
        SqrtCalculator srtc = (inpt) -> Math.sqrt(inpt);

        //3.3 : execute lambda
        System.out.println("Sqrt of 16 is " + srtc.calculateSqrt(16));

    }
}

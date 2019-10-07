package com.examples.corejava.java8;


import java.util.function.Function;

/**
 * function composition:
 *      creating small reusable functions that you can combine to compose new functions.
 *
 * Use of two compose functions provided in the Function interface - "compose" and "andThen".
 *
 * the difference between compose and andThen is the order they execute the functions.
 * While the compose function executes the caller last and the parameter first,
 * the andThen executes the caller first and the parameter last.
 *
 * Ref: https://www.deadcoderising.com/2015-09-07-java-8-functional-composition-using-compose-and-andthen/
 *
 */



public class LambdaFunction02 {
    private static final Integer INPUT_DIGIT = 3;


    public static void main(String[] args) {

        //----------  Function Logic ---------------

        //primitives not allowed , hence wrapper Integer used

        //Function<String, String> addPrefix = (int1) -> " >>> " + int1 ;
        Function<Integer, Integer> addFive = (int1) -> {
            System.out.println("Inside addFive");
            return int1 +5 ;
        };


        //Function<String, String> addSuffix = (int2) -> int2 + " <<< ";
        Function<Integer, Integer> multiply10 = (int2) -> {
            System.out.println("Inside multiply10");
            return int2 * 10;
        };

        //------ TEST -----------------

        //compose(=before) : addSuffix -> addPrefix = (3*10)+5 =35
        int resultUsingCompose = addFive.compose(multiply10).apply(INPUT_DIGIT);
        System.out.println("resultUsingCompose : " + resultUsingCompose);

        System.out.println("\n");

        // andThen(=after) : addPrefix -> addSuffix =(3+5)*10=80
        int resultUsingAndThen = addFive.andThen(multiply10).apply(INPUT_DIGIT);
        System.out.println("resultUsingAndThen : " + resultUsingAndThen);


        //Another example (non related to above)
        Function<String, String> toUppercase = String::toUpperCase;
        String testInput = "tEsT INpuT";
        System.out.println("Uppercase of [" + testInput + "] is [" + toUppercase.apply(testInput) + "]" );
    }
}

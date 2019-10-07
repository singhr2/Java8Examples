package com.examples.corejava.java8;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Demo for Consumer Functional Interface
 * In the basic form shown here, it is just printing input on console
 */
public class LambdaFuntion03 {
    public static void main(String[] args) {
        Consumer<String> c1 =  System.out::println;

        c1.accept("Just print the input message");
    }
}

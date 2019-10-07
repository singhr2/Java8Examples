package com.examples.corejava.java8;

import java.util.Arrays;
import java.util.List;

/**
 * A method reference (::) is the shorthand syntax for a lambda expression that executes just ONE method.
 *
 * Where ever we can pass a lambda expression that just calls a static method, we can use a method reference.
 *
 * A method reference is the shorthand syntax for a lambda expression that executes just ONE method.
 * e.g.,
 *  Instead of
 *          Consumer<String> c = s -> System.out.println(s);
 *  use
 *          Consumer<String> c = System.out::println;
 *
 *  First of all, a method reference can't be used for any method. They can only be used to replace a single-method lambda expression.
 *
 * So to use a method reference, you first need a lambda expression with one method.
 * And to use a lambda expression, you first need a functional interface,
 * an interface with just one abstract method.
 *
 * In short :
 * Instead of using  "AN ANONYMOUS CLASS"
 * you can use       "A LAMBDA EXPRESSION"
 * And if this just calls one method,
 * you can use      "A METHOD REFERENCE"
 *
 * Ref: https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Type                                     Syntax                                         Lambda
 * Reference to a static method             ClassName::staticMethodName                    (args) -> ClassName.staticMethodName(args)
 *
 * Reference to an instance method of an existing object
 *                                          object::instanceMethodName                     (args) -> object.instanceMethodName(args)
 *
 * Reference to an instance method of an arbitrary object of a particular type
 *                                          ClassName::instanceMethodName                   (arg0,rest) -> arg0.instanceMethodName(rest)
 *
 * Note: argo is of type ClassName
 *
 * Reference to a constructor               ClassName::new                                  (args) -> new ClassName(args)
 *
 * * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Instance method reference:
 * "abc"::length
 *
 */
public class MethodReference01 {
    private static List<String> keywords = Arrays.asList("Item1", "Item2");

    public static void main(String[] args) {
        //Print all system properties
        System.getProperties().forEach((k,v) -> System.out.println("Key:" + k +", Value:" +v));

        //-----------------------------------------------

        //single expression
        keywords.forEach(System.out::println);

        //multiple expression
        keywords.forEach((item)  -> {
            System.out.println("Current item:" + item);
            System.out.println( System.getProperty(item));
        });

    }
}

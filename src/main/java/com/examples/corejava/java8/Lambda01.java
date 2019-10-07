package com.examples.corejava.java8;

/**
 *   functional interface - interface with a SAM(Single Abstract Method)
 *   and its implementation may be treated as lambda expressions.
 *   Ref: https://www.baeldung.com/java-8-functional-interfaces
 *
 *   function interface (this interface contains one — and only one — abstract method
 *   but also can contain multiple default and static methods)
 *
 * Example:
 * 1) Runnable : It contains only run() method
 * 2) Comparable : It contains only compareTo() method
 * 3) ActionListener : It contains only actionPerformed()
 * 4) Callable : It contains only call()method
 *
 *  Some of the useful java 8 functional interfaces are Consumer, Supplier, Function and Predicate.
 */

//[1] Declare Functional Interface(FI)
@FunctionalInterface
interface ZeroArgsFunctionalInterface{
    String greetUser();
}

@FunctionalInterface
interface BasicArithmetic{
    int calculate(int i1, int i2);
}

@FunctionalInterface
interface GreetDeveloper{
    void sayHi(String user);
}
public class Lambda01 {
    public static void main(String[] args) {

        /*
         *  Note: The Type of a Lambda Expression is a Functional Interface (here it is ZeroArgsFunctionalInterface)
        */

        //[2] Assign the FI with the logic
        ZeroArgsFunctionalInterface zafi = () -> {
            System.out.println("Some Business Logic here");
            return "Hello World !";
        };

        //[3] Call the same
        System.out.println(zafi.greetUser());

        //================================================================


        //================================================================
        BasicArithmetic addOp = (n1, n2) -> n1+n2;
        System.out.println(addOp.calculate(1,2));

        //================================================================
        //GreetDeveloper gd = (devID) -> System.out.println(devID);
        GreetDeveloper gd = System.out::println;


    }
}

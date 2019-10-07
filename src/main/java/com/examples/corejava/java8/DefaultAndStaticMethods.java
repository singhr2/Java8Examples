package com.examples.corejava.java8;

interface Intf1{
    /*
     [ default methods / Defender Methods / Virtual extension methods ]

     introduced to provide backward compatibility for old interfaces
     so that they can have new methods without effecting existing code.

     <!> A default method cannot override a method from java.lang.Object
     */
    default void defaultMethod(){
        System.out.println( "from Intf1.defaultMethod() default method.");
    }

    /*
     [ static method ]
     static methods contain the complete definition of the function
     and since the definition is complete and the method is static,
     therefore these methods cannot be overridden or changed in the implementation class.
     */
    static void staticMethod() {
        System.out.println( "from Intf1.staticMethod() static method.");
    }
}

interface Intf2{
    default void defaultMethod(){
        System.out.println("from Intf2.defaultMethod() default method.");
    }

    static void staticMethod() {
        System.out.println("from Intf2.staticMethod() static method.");
    }
}

public class DefaultAndStaticMethods implements  Intf1, Intf2{
    /*
    [ Note ]
    it’s made mandatory to provide implementation for common default methods of interfaces.

    If we don't override this default method, we will get compile-time error "inherits unrelated defaults".
    So until you don't create ambiguity by using default methods on interfaces, you are fine to use it.
    If it creates ambiguity, the compiler will alert you by throwing above error .
    */
    @Override
    public void defaultMethod() {
        System.out.println("from Overriden DefaultAndStaticMethods.defaultMethod()");
    }

    // Note
    // static methods from interface cant be overriden


    private static void printValuesInStaticMethod() {
        //**** CALL DEFAULT METHODS ****

        //ERROR : Non-static method can't be referenced from static context
        //defaultMethod(); // calls overriden default (non-static) method

        //ERROR: Intfx is not an enclosing class
        //Intf1.super.defaultMethod();
        //Intf2.super.defaultMethod();

        //*** CALL STATIC METHODS
        Intf1.staticMethod();
        Intf2.staticMethod();
    }

    private void printValuesInInstanceMethod() {
        //**** CALL DEFAULT METHODS ****
        defaultMethod(); // calls overriden default (non-static) method
        Intf1.super.defaultMethod();
        Intf2.super.defaultMethod();

        //*** CALL STATIC METHODS
        Intf1.staticMethod();
        Intf2.staticMethod();
    }

    public static void main(String[] args) {
        DefaultAndStaticMethods obj = new DefaultAndStaticMethods();

        //OK
         //obj.printValuesInInstanceMethod();

         //OK
         printValuesInStaticMethod();
    }
}
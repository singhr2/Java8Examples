package com.examples.corejava.java8;

@FunctionalInterface
interface SomeFunctionalInterface{
    void printText(String s);
}

public class AccessingVariablesInLambda {
    private static final String SOME_CONSTANT = "constant";
    private String instanceVariable = "instance";
    private static String classVariable = "instance";

    //static method
    private static void printAllValuesInsideStaticMethod(String str){
        System.out.println("### SOME_CONSTANT :" + SOME_CONSTANT);

        //ERROR : Non-static field can't be referenced from a static context
        //System.out.println("### instanceVariable :" + instanceVariable);
        //System.out.println("### instanceVariable :" + this.instanceVariable);

        System.out.println("### classVariable :" + classVariable);

        System.out.println("### Received Input :" + str);
    }

    //instance method
    private void printAllValuesInsideInstanceMethod(String str){
        System.out.println("$$$ SOME_CONSTANT :" + SOME_CONSTANT);

        //ERROR : Non-static field can't be referenced from a static context
        System.out.println("$$$ instanceVariable :" + instanceVariable); //can use 'this.instanceVariable' as well

        System.out.println("$$$ classVariable :" + classVariable);

        System.out.println("$$$ Received Input :" + str);
    }

    public static void main(String[] args) {

        AccessingVariablesInLambda obj1 = new AccessingVariablesInLambda();


        //Assign logic to lambda
        SomeFunctionalInterface sfi = (str) ->{
            // Working OK - except it dont print instance variable values
            // printAllValuesInsideStaticMethod(str);

            //Working ok - prints instance variable value as well
           obj1.printAllValuesInsideInstanceMethod(str);
        };

        //invoke lambda
        sfi.printText("Hello");
    }
}

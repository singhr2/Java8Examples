package com.examples.corejava.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*

    You use lambda expressions to create anonymous methods.
    Sometimes, however, a lambda expression does nothing but call an existing method.
    In those cases, it's often clearer to refer to the existing method by name.

    There are four kinds of method references :
    * Reference to a static method — ContainingClass::staticMethodName
    * Reference to an instance method of a particular object — containingObject::instanceMethodName
    * Reference to an instance method of an arbitrary object of a particular type _ ContainingType::methodName
    * Reference to a constructor — ClassName::new
* super::instanceMethod


    1)
     System.out::println
        is equivalent to
     x -> System.out.println(x)

    2)
     Math::pow
        is equivalent to
     (x, y) -> Math.pow(x, y)

 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
        MethodRef mr = new MethodRef();
        mr.publicMethod();
    }
}


class MethodRef {
    public void printLowerCase(String s) {
        System.out.println(s.toLowerCase());
    }

    public static void printUpperCase(String s) {
        System.out.println(s.toUpperCase());
    }

    public void publicMethod() {
        List<String> list = Arrays.asList("A", "B", "C");
        list.forEach(this::printLowerCase);
        list.forEach(MethodRef::printUpperCase);
        list.forEach(String::toLowerCase);
        list.forEach(String::new);

        list.forEach(System.out::println);

        //------ another example ----------

        // old way
        System.out.println("Printing List elements - old way");

        //option-1
        String str[] = { "Java 7", "Java 8", "Java 9" };
        List<String> listOfOrders = Arrays.asList(str);
        //-or-
        //option-2
        //List<String> listOfOrders = Arrays.asList("Test", "Message", "Some", "More");

        for(String s : listOfOrders){
            System.out.println(s);
        }

        // with Java 8 method reference
        System.out.println("Printing List elements - Java8 Method Reference way");
        listOfOrders.forEach(System.out::println);

        //------ another example ----------

        String[] buttons = listOfOrders.stream().toArray(String[]::new);

    }
}
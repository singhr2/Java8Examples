package com.examples.corejava.java8;

/**
 *  Lambda expressions can only be assigned to functional interface references
 *
 *  !!! The Type of a Lambda Expression is a Functional Interface.
 *
 *
Lambda expressions are used primarily to define inline implementation of a functional interface.

 A Java lambda expression is thus a function which can be created without belonging to any class.

Any interface with a SAM(Single Abstract Method) is a functional interface,
and
 ***** its implementation may be treated as lambda expressions. *****


 statement lambda : param -> { return expression; }
 expression lambda: param -> expression

Syntax examples:
* No parameter: () -> System.out.println("Nothing")
* One parameter: x -> x+2
* Two parameters: (x,y) -> x+y
* With parameter types: (Integer x, Integer y) -> x+y
* Multiple statements:
    (x,y) ->  { System.out.println(x); System.out.println(y); return x+y; }
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BasicLambda {
    public static void main(String[] args) {
        //1.a : Pre-Java8
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("## t1 Inside Thread.run()");
            }
        });

        System.out.println("Before running thread.");
        t1.start();

        //1.b :With Java8/

        //Thread requires Runnable interface
        //
        //expression lambda : body consists of a single line, so no braces are required.
        // other format is :
        // block lambda : Uses braces {}
        // braces now allow for multiple statements. The return keyword is now required.
        Thread t2 = new Thread(() -> System.out.println("** t2 Inside Thread.run()"));
        t2.start();

        //-----------------------------------------------------------
        List<String> l1 = Arrays.asList("b", "z", "a");

        //2.a Collection sorting - old way
        Collections.sort(l1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("Pre-Java8 : sorted result is ->" + l1);

        //2.a Collection sorting - Java8 way
        l1 = Arrays.asList("b2", "z2", "a2");
        //lambda instead of overriden method
        //sort (List<T> , Comparator<? super T> )
        Collections.sort(l1, ((o1, o2) -> o1.compareTo(o2)));
        System.out.println("With--Java8 : sorted result is ->" + l1);

        //Collections.sort(l1, Collections.reverseOrder());
        System.out.println("reverse sorted result is ->" + l1 );
    }
}

package com.examples.corejava.java8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  Demo for using method reference for instantiating class
 */
public class LambdaConstructorReferences {
    public static void main(String[] args) {
        //old school approach
        List l1 = new ArrayList();

        //ERROR : List/String is not a FunctionalInterface
        //List<Integer> integers2 = ArrayList::new;
        //String sb = String::new;
        Supplier<String> sb = String::new; // option-1
        Supplier<String> sb2 = () -> { //option-2
            return new String();
        };


        //TODO How this is working ?
        List<Integer> integers = IntStream
                .range(1, 100)
                .boxed()
                .collect(Collectors.toCollection( ArrayList::new ));


        //SingleArgsFunctionalInterface s1 = SingleArgsFunctionalInterface::new;
        //Supplier<Integer> integerSupplier = Integer::new;


    }
}

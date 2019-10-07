package com.examples.corejava.string;

/*
Problem Statement:
How to Join Strings in List

Note: About Lombok {not working}
In case @Slf4j is not processed, try:
1) File > Invalidate Caches / Restart > Invalidate and Restart
or
2)  Annotation processing seems to be disabled for the project "".
But lombok is on classpath. For the lombok plugin to function correctly,
please enable it under "Settings > Build > Compiler > Annotation Processors"


*/

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Data
public class StringJoin {
    private static final List<String> values = Arrays.asList("One", "five", "three", "four", "two");
    private static final String VALUES_SEPARATOR = "~";


    private static void preJava8Approach() {
        //Pre-Java8 approach
        StringBuilder combinedString = new StringBuilder();
        for(String s : values){
            //TODO add condition to not add separator at end
            combinedString.append(s).append(VALUES_SEPARATOR);
        }

        log.info("Combined String -  preJava8Approach():" + combinedString.toString());
    }

    private static final void java8Approach(){
        String str = String.join("~", values);
        log.info("Combined String - java8Approach():" + str);
    }

    public static void main(String... args){
        preJava8Approach();
        java8Approach();

        //sorted values
        //Use Collections.sort() method sort a list of objects.
        //Use Arrays.sort() method sort an array of objects.
        String[] valuesAsString = (String[])values.toArray();
        Arrays.sort(valuesAsString);

        //-----------------------------------------------
        System.out.println("Printing sorted values using  Arrays.sort");
        for(String value : valuesAsString){
            System.out.println("->" + value);
        }

        //-----------------------------------------------
        //Sorting using Collections.sort
        System.out.println("Printing sorted values using  Collections.sort");
        Collections.sort(values);
        values.forEach(System.out::println);
    }
}

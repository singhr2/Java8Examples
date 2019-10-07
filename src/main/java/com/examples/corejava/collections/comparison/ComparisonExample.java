package com.examples.corejava.collections.comparison;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Data
@AllArgsConstructor
class MySampleObject implements Comparable{
    private Integer objID;  // used instead of int pritive to support compareTO
    private String objCategory;
    private LocalDate effectiveDate;

    @Override
    public int compareTo(Object other) {
        //simple comparison based on objID
        //System.out.println("this.getObjID() :" + this.getObjID() + ", other.getObjID() :" + ((MySampleObject)other).getObjID());

        return this.getObjID().compareTo(((MySampleObject)other).getObjID());
    }
}

public class ComparisonExample {
    // private static final int BEFORE = -1; //  the first object is less than the second one.
    // private static final int EQUAL = 0; //
    // private static final int AFTER = 1; //he first object is greater than the second one.

    static final String DATE_FORMAT = "dd/MM/yyyy";
    static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);

    static final List<MySampleObject> collOfSampleObjects
            = Arrays.asList(
            new MySampleObject(new Integer(1001), "Employee", LocalDate.of(2018, 12, 25)),
            new MySampleObject(new Integer(201), "Visitor", LocalDate.parse("01/02/2017", dateFormat)),
            new MySampleObject(new Integer(1001), "Contractor", LocalDate.now()),
            new MySampleObject(new Integer(1001), "Employee", LocalDate.now())
    );

    public static Comparator<MySampleObject> comparatorUsingThreeFields
            = Comparator.comparing( MySampleObject::getObjID )  //compare by first Name
            .thenComparing(MySampleObject::getObjCategory)   // compare by object category
            .thenComparing(MySampleObject::getEffectiveDate); // compare by effective date

    public static void main(String[] args) {
        System.out.println("Before :" + collOfSampleObjects);

        Collections.sort(collOfSampleObjects);

        System.out.println("After sort by ObjID:" + collOfSampleObjects);

        System.out.println("Comparing using the Comparator based on 3 fields");
        Collections.sort(collOfSampleObjects, comparatorUsingThreeFields);
        System.out.println("After sort by comparatorUsingThreeFields:" + collOfSampleObjects);

        System.out.println("reversed Comparing using the Comparator based on 3 fields");
        Collections.sort(collOfSampleObjects, comparatorUsingThreeFields.reversed());
        System.out.println(" -->" + collOfSampleObjects);

        //transversing using Java8 java.lang.Iterator.forEach
        System.out.println("Reverse Transversing using forEach...");
        collOfSampleObjects.forEach( curObj -> System.out.println( "-> " + curObj + "\n") );
    }
}


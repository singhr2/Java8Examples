package com.examples.corejava.java8;

//declare
@FunctionalInterface
interface SingleArgsFunctionalInterface{
    String greetUser(String username);
}

public class Lambda02 {
    public static void main(String[] args) {
        //associate logic/code
        //after = , provide the business logic
        //i.e. what code does safi represents here
        SingleArgsFunctionalInterface safi = (uname) -> "Hello " + uname +" !";

        //If {} are used, specify return clause.
        SingleArgsFunctionalInterface safi2 = (uname) -> {  return "Hey " + uname +" !" ;};

        //execute
        System.out.println(safi.greetUser("Ranbir"));
        System.out.println(safi2.greetUser("Singh"));
    }
}

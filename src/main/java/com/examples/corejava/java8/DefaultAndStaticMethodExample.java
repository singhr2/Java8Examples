package com.examples.corejava.java8;

//Source code Credit : https://www.tutorialspoint.com/java8/java8_default_methods.htm

interface Vehicle {

    default void print() {
        System.out.println("I am a vehicle!");
    }

    static void blowHorn() {
        System.out.println("Blowing horn!!!");
    }
}

interface FourWheeler {

    default void print() {
        System.out.println("I am a four wheeler!");
    }
}

class Car implements Vehicle, FourWheeler {

    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("I am a car!");
    }
}

public class DefaultAndStaticMethodExample {

    public static void main(String args[]) {
        Vehicle vehicle = new Car();
        vehicle.print();
    }
}

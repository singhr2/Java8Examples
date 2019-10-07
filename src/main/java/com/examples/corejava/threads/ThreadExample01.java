package com.examples.corejava.threads;

public class ThreadExample01 {
    public static void main(String... args){
        Runnable r1 = new Runnable() { // Thread implementation
            @Override
            public void run() {
                System.out.println("inside run() method");
            }
        };

        r1.run();
    }
}
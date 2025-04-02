package org.core.exceptionpropagation;

public class ExceptionPropagation {
    public static void main(String[] args) {
        try {
            Method1();
        }
        catch (Exception e) {
            System.out.println("Catch Exception");
        }
    }

    public static void Method1() {
        Method2();
    }
    public static void Method2() {
        Method3();
    }
    public static void Method3() {
        throw new RuntimeException();
    }
}

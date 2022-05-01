package com.fkog.defensiveProgramming;

import java.util.Objects;

public class Lesson1 {
    private int integerVal;
    /**
     *
     * @param intVal
     * @return typecasted long value of intVal
     */
    private static long convertToLong(int intVal){
        return (long) intVal;
    }

    /**
     *
     * @param longVal
     * @return
     */
    private static long convertToInt(long longVal){
        soutLongVal(longVal);
        return longVal;
    }

    private static void soutLongVal(long longVal) {
        System.out.println("inside method: "+ longVal);
    }

    private static long increment(long longToIncrement){
        return ++longToIncrement;
    }
    public static void main(String[] args) {
//        int a = Integer.MAX_VALUE +1;
        /*make sure integer is */
        long a = Integer.MAX_VALUE +(long)1;
        long longVal = Lesson1.convertToInt(a);
        System.out.println("returned value: "+longVal);
        System.out.println("expected: "+((long)Integer.MAX_VALUE+1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson1 lesson1 = (Lesson1) o;
        return integerVal == lesson1.integerVal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(integerVal);
    }
}

package org.example.DZ_3;

public class Calculator {
    public static <T extends Number> double sum(T num1, T num2){
        return num1.doubleValue() + num2.doubleValue();
    }
    public static <T extends Number> double multiply(T num1, T num2){
        return num1.doubleValue() * num2.doubleValue();
    }
    public static <T extends Number> double divide(T num1, T num2){
        if (num2.doubleValue() == 0){
            System.out.print("Делить на ноль нельзя!");
            return 0;
        }
        return num1.doubleValue() / num2.doubleValue();
    }
    public static <T extends Number> double subtract(T num1, T num2){
        return num1.doubleValue() - num2.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(5,5));
        System.out.println(Calculator.divide(5,0));
        System.out.println(Calculator.divide(10,5));
        System.out.println(Calculator.multiply(5,5));
        System.out.println(Calculator.subtract(10,5));
    }
}

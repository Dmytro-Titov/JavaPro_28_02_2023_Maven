package com.hillel.lesson18.hw14;

public class Calculator {
    public static void main(String[] args) {
        double firstNumber = Double.parseDouble(args[0]);
        String operator = args[1];
        double secondNumber = Double.parseDouble(args[2]);

        switch (operator) {
            case "+" -> System.out.println(firstNumber + secondNumber);
            case "-" -> System.out.println(firstNumber - secondNumber);
            case "/" -> System.out.println(firstNumber / secondNumber);
            case ("x"), ("*") -> System.out.println(firstNumber * secondNumber);
        }
    }
}

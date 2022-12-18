package ru.mirea.exercise1;

import java.util.Stack;

public class ReversePolishNotation {
    public static String running(String string){
        Stack<Double> stack = new Stack<>();
        String[] str = string.split(" ");
        for (String element : str){
            if (numeric(element)) {
                stack.push(Double.parseDouble(element));
            }
            else if (element.equals("+") | element.equals("-") | element.equals("*") | element.equals("/")) {
                double x;
                double y;
                if (!stack.isEmpty()) {
                    y = stack.pop();
                }
                else {
                    return "Error";
                }
                if (!stack.isEmpty()) {
                    x = stack.pop();
                }
                else {
                    return "Error";
                }
                if (element.equals("+")) {
                    stack.push(amount(x, y));
                }
                if (element.equals("-")) {
                    stack.push(subtraction(x, y));
                }
                if (element.equals("*")) {
                    stack.push(multiplication(x, y));
                }
                if (element.equals("/")) {
                    if (y != 0.0) {
                        stack.push(division(x, y));
                    }
                    else {
                        return "Division by 0";
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            return stack.pop().toString();
        }
        else {
            return "Numbers or operations not found";
        }
    }

    private static double amount(double x, double y) {
        return x + y;
    }

    private static double subtraction(double x, double y) {
        return x - y;
    }

    private static double multiplication(double x, double y) {
        return x * y;
    }

    private static double division(double x, double y) {
        return x / y;
    }

    private static boolean numeric(String string) {
        try {
            Double.parseDouble(string);
            return true;
        }
        catch(NumberFormatException exception) {
            return false;
        }
    }
}

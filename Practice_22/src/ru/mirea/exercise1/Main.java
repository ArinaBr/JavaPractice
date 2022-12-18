package ru.mirea.exercise1;

public class Main {
    public static void main(String[] args) {
        String[] calculator = new String[]{
                "12 43 +",
                "12 234 -",
                "12 12 *",
                "12 12 /",
                "12 0 /",
                "12 45 + - +",
                "12 =",
                "+",
                "Hello world",
                "Hello world - = +- + - *"
        };
        for (String test : calculator){
            System.out.printf("%s : %s\n", test, ReversePolishNotation.running(test));
        }
    }
}

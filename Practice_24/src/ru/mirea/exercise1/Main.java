package ru.mirea.exercise1;

public class Main {
    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory(7, 10);
        System.out.println(factory.createComplex());
        System.out.println(factory.createComplex(7, 10));
    }
}

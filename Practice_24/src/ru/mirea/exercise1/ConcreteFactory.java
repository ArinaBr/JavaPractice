package ru.mirea.exercise1;

public class ConcreteFactory implements ComplexAbstractFactory {
    private int real;
    private int image;

    public ConcreteFactory(int real, int image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public Complex createComplex() {
        return new Complex();
    }

    @Override
    public Complex createComplex(int real, int image) {
        return new Complex(real, image);
    }
}

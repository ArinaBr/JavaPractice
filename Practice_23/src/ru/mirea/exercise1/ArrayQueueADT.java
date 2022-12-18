package ru.mirea.exercise1;

public abstract class ArrayQueueADT<T> {
    public int front;
    public int rear;
    public int size;
    public T items[];

    public ArrayQueueADT(Class<T> dataType, int size) {
        this.size = size;
        this.front = -1;
        this.rear = -1;
        this.items = (T[]) java.lang.reflect.Array.newInstance(dataType, size);
    }

    boolean full() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        return false;
    }

    boolean empty() {
        if (front == -1) {
            return true;
        }
        else {
            return false;
        }
    }

    void insert(T element) {
        if (full()) {
            System.out.println("Queue is full");
        }
        else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = element;
            System.out.println(element + " is inserted");
        }
    }

    T delete() {
        T element;
        if (empty()) {
            System.out.println("Queue is empty");
            return null;
        }
        else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            }
            else {
                front++;
            }
            System.out.println(element + " is deleted");
            return element;
        }
    }

    void display() {
        int i;
        if (empty()) {
            System.out.println("Empty queue");
        }
        else {
            System.out.println("Front index: " + front);
            System.out.println("Items:");
            for (i = front; i <= rear; i++) {
                System.out.println(items[i]);
            }
            System.out.println("Rear index: " + rear);
        }
    }
}

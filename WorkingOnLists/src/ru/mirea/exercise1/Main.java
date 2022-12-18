package ru.mirea.exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List list = new List();
        while (true) {
            boolean check = false;
            System.out.println("DATABASE: \n" + "1. Showing the list \n" + "2. Add entry \n" + "3. Remove entry \n" + "4. Exit");
            int act = Integer.parseInt(scanner.nextLine());
            switch (act) {
                case 1:
                    System.out.println(list);
                    break;
                case 2:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter grade:");
                    int grade = Integer.parseInt(scanner.nextLine());
                    list.add(name, grade);
                    System.out.println("Done");
                    break;
                case 3:
                    for (int i = 1; i < list.size() + 1; i++) {
                        System.out.println(" " + i + ") " + list.get(i));
                    }
                    int index = Integer.parseInt(scanner.nextLine());
                    if (index <= list.size()) {
                        list.remove(index);
                    }
                    System.out.println("Done");
                    break;
                case 4:
                    check = true;
                    break;
            }
            if (check) {
                break;
            }
        }
    }
}

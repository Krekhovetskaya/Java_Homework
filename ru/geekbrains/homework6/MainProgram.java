package ru.geekbrains.homework6;

import java.util.HashSet;

public class MainProgram {
    public static void main(String[] args) {

        HashSet<Cat> hashSet = new HashSet<>();
        hashSet.add(new Cat("Pushok", "white", 3, "Male"));
        hashSet.add(new Cat("Barsik", "brown", 3, "Male"));
        hashSet.add(new Cat("Smoky", "grey", 2, "Male"));
        hashSet.add(new Cat("Pushok", "white", 3, "Male"));
        hashSet.add(new Cat("Ted", "black", 8, "Male"));
        hashSet.add(new Cat("Smoky", "grey", 2, "Male"));
        hashSet.add(new Cat("Vasya", "white", 3, "Male"));
        hashSet.add(new Cat("Vasya", "white", 3, "Male"));
        hashSet.add(new Cat("Asya", "black", 2, "Female"));
        hashSet.add(new Cat("Barsik", "brown", 3, "Male"));
        

        System.out.println(hashSet);
    }
}
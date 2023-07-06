package ru.geekbrains.homework5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//Написать простой класс Телефонный Справочник (с помощью HashMap), который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

public class homework5 {
    

   public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        addNumber("Ваня Иванов", 123, phoneBook);
        addNumber("Лиза Креховецкая", 1234, phoneBook);
        addNumber("Ваня Иванов", 546585, phoneBook);
        addNumber("Евгений Сидоров", 8956477, phoneBook);
        addNumber("Маша Петрова", 12356233, phoneBook);
        addNumber("Лиза Креховецкая", 787897, phoneBook);
        printBook(phoneBook);
    }
    
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map) { // Метод, добавляющий номера в книгу
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
    
    public static void printBook(Map<String, ArrayList<Integer>> map) { // Метод, печатающий список контактов
        for (var item : map.entrySet()) {
            String phones = "";
            for (int el : item.getValue()) {
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
}
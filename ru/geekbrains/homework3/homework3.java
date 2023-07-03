package ru.geekbrains.homework3;

// Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Random;
// import java.util.Arrays;
// import java.io.FileWriter;


public class homework3 {
    
  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean f = true;
        while(f)
        {
            System.out.println("Укажите номер задачи:");
            System.out.println("1 - удаление четных:");
            System.out.println("2 - поиск min,max,aver:");
            System.out.print("Введите номер задачи: ");
            int no = Integer.parseInt(scanner.nextLine());

            if (no == 1){
                 task1(args);
             }
                else if (no == 2){
                task2(args);
            }
        
        }
        
    }
     
     // Пусть дан произвольный список целых чисел.1) Нужно удалить из него чётные числа

    public static void task1(String[] args) {
        ArrayList<Integer> numbers = getRandomList(10, 15);
        System.out.printf("Первоначальный список:     %s\n", numbers.toString());
        System.out.printf("Список нечетных элементов: %s\n", getOddList(numbers).toString());
    }

    private static ArrayList<Integer> getOddList(ArrayList<Integer> list) {

        Iterator<Integer> iteratorList = list.iterator();

        while (iteratorList.hasNext()) {
            int item = iteratorList.next();
            if (item % 2 == 0) iteratorList.remove();
        }
        return list;
    }

    private static ArrayList<Integer> getRandomList(int size, int upperBond) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(upperBond));
        }
        return list;
    }

    


//2) найти min max и aver значение

 public static void task2(String[] args) {
        
        ArrayList<Integer> numbers = getRandomList(10, 50);
        int maxElement = findMax(numbers);
        int minElement = findMin(numbers);
        double averageValue = getAverageValue(numbers);

        System.out.printf("Полученный список: %s\n", numbers.toString());
        System.out.printf("Максимальное значение в списке: %d\nМинимальное значение списка: %d\n" +
                "Среднее арифмитеческое элементов списка: %.2f\n", maxElement, minElement, averageValue);
    }
    public static int findMax(ArrayList<Integer> arr){
        int max = arr.get(0);
        for(int element : arr){
            if(element > max) max = element;
        }
        return max;
    }
    public static int findMin(ArrayList<Integer> arr){
        int min = arr.get(0);
        for(int element : arr){
            if(element < min) min = element;
        }
        return min;
    }

     private static Double getAverageValue(ArrayList<Integer> list) {
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        double averageValue = (double) sum / list.size();
        return averageValue;
    }
}

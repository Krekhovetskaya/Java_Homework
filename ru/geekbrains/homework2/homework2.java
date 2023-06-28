package ru.geekbrains.homework2;


import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class homework2 {
    
  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean f = true;
        while(f)
        {
            System.out.println("Укажите номер задачи:");
            System.out.println("1 - json строка:");
            System.out.println("2 - сортировка пузырьком:");
            System.out.print("Введите номер задачи: ");
            int no = Integer.parseInt(scanner.nextLine());

            if (no == 1){
                 task1(args);
             }
                else if (no == 2){
                task2(args);
            }
            // else if (no == 3){
            //     f = false;
            //     task3(args);
            // }
        }
        
    }
 
    
     // Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
     // Данные для фильтрации приведены ниже в виде json-строки.
     //Если значение null, то параметр не должен попадать в запрос.
     //Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

    public static void task1(String[] args){
                StringBuilder request = new StringBuilder();   
        String[] str = {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"};
           
        for (int i = 0; i < str.length; i++) {
            if (str[i].indexOf("null") == -1) {                            
                request.append(str[i].replace(":", "="));
                if (i != str.length - 2) {                                       
                    request.append(" AND ");
                }
            }
        }
        System.out.println(request);                                     
    }


//2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

public static void task2(String[] args) {
        int[] array = createRandomArray(10, 0, 11);
        System.out.print("Созданный массив:       ");
        System.out.println(showArray(array));
        int[] sortArray = bubbleSort(array);
        System.out.print("Массив отсортирован: ");
        System.out.println(showArray(sortArray));
    }

    static int[] createRandomArray(int size, int downBound, int upperBond) { 
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(upperBond) + downBound;
        }
        return array;
    }

    static String showArray(int[] array) {                                  
        return Arrays.toString(array);
    }
    static int[] bubbleSort(int[] array) {                                                                    
        int[] sortArray = Arrays.copyOf(array, array.length);
        int temp = 0;
        for (int i = 0; i < sortArray.length; i++) {
            for (int j = 0; j < sortArray.length - i - 1; j++) {
                if (sortArray[j] > sortArray[j + 1]) {
                    temp = sortArray[j+1];
                    sortArray[j + 1] = sortArray[j];
                    sortArray[j] = temp;                  
                }
            }
            WriteToFile(sortArray);
        }
        return sortArray;
    }
    static void WriteToFile(int[] array) {                                           
        try (FileWriter f = new FileWriter("logTask02.txt", true)) {
            f.write(Arrays.toString(array));
            f.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
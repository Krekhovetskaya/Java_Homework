package ru.geekbrains.Homework1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Homework1{

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean f = true;
        while(f)
        {
            System.out.println("Укажите номер задачи:");
            System.out.println("1 - n-е треугольное число:");
            System.out.println("2 - простые числа от 0 до 1000:");
            System.out.println("3 - Калькулятор");
            System.out.print("Введите номер задачи: ");
            int no = Integer.parseInt(scanner.nextLine());

            if (no == 1){
                task1(args);
            }
            else if (no == 2){
                task2(args);
            }
            else if (no == 3){
                f = false;
                task3(args);
            }
        }
        
    }

    /* Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
     */

    public static void task1(String[] args){
        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        int sum;
        sum = n*(n+1)/2;

        int factorial = 1;
        if (n==0 && n==1){
            factorial = 1;
        } else {
            for (int i = 2; i <= n; i++){
                factorial *=i;
            }

        }
                
        System.out.printf("Сумма чисел от 1 до " + n + " равна: %s\n", sum);
        System.out.printf("Факториал чисел от 1 до " + n + " равен: %s\n", factorial);
    }

    /*
     * * Вывести все простые числа от 1 до 1000
     */
    public static void task2(String[] args) {
    boolean flag = true;    
    for (int number = 2; number <= 1000; number++) {
        for (int index = 2; index < number; index++) {
            if (number % index == 0){
                flag = false;
                break;
            }
        }
        if (flag == true)
        System.out.print(number + " ");
        else flag = true;                
        }
    } 


/*
     * * Реализовать простой калькулятор
     */


    
    static File fileLog;
    static FileWriter fileWriter;
    public static void task3(String[] args) {

        try
        {
            fileLog = new File("log.txt");
            fileWriter = new FileWriter(fileLog);
            for (int i = 0; i < 5; i ++){
                fileWriter.write("hello! " + i + '\n');
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            double x = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите операцию (+ - * /): ");
            char operation = scanner.nextLine().charAt(0);
            System.out.print("Введите второе число: ");
            double y = Double.parseDouble(scanner.nextLine());
            if (operation == '+'){
                System.out.println(x + " + " + y + " = " + plus(x, y));
                System.out.printf("%.2f + %.2f = %.2f\n", x, y, plus(x, y));
            }
            if (operation == '-'){
                System.out.println(x + " - " + y + " = " + minus(x, y));
                System.out.printf("%.2f - %.2f = %.2f\n", x, y, minus(x, y));
            }


            fileWriter.close();
        }
        catch(Exception e){

        }



    }

    static double plus(double a, double b){
        // fileWriter.write(...);
        return a + b;
    }

    static double minus(double a, double b){
        return a - b;
    }

}

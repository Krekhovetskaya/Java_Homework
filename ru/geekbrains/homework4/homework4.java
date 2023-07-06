package ru.geekbrains.homework4;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class homework4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean f = true;
        while(f)
        {
            System.out.println("Укажите номер задачи:");
            System.out.println("1 - перевернутый список:");
            System.out.println("2 - калькулятор:");
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


 // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

    public static void task1(String[] args){

        LinkedList<Integer> integerLinkedList = createList(10);
        System.out.print("Cозданный LinkedList:    ");
        System.out.println(integerLinkedList);

        integerLinkedList = reverseList(integerLinkedList);
        System.out.print("Перевернутый LinkedList: ");
        System.out.println(integerLinkedList);
    }

    static LinkedList<Integer> createList(int size) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(i + 1);
        }
        return linkedList;
    }

    static LinkedList<Integer> reverseList(LinkedList<Integer> linkedList) {
        LinkedList<Integer> newList = new LinkedList<>();
        while (linkedList.size() > 0) {
            newList.add(linkedList.pollLast());
        }
        return newList;
    }


  // В калькулятор (урок 1 и 2) добавьте возможность отменить последнюю операцию.

    public static void task2(String[] args) {  

        Stack<Integer> st = new Stack<>();
            System.out.print("Введите первое число: \n");
            st.push(scanner.nextInt());
            char op = operation();
            System.out.print("Введите второе число: \n");
            st.push(scanner.nextInt());
            calc(st, op);
            while (true) {
                System.out.println("Отменить последнюю операцию?\nДа - 'y';\nНет - 'n'");
                op = scanner.next().charAt(0);
                if (op == 'y') {
                    System.out.println("Первое число: " + st.peek());
                    op = operation();
                    System.out.print("Введите второе число: ");
                    st.push(scanner.nextInt());
                    calc(st, op);
                    continue;
                }
                if (op == 'n') {
                    System.out.println("Программа завершена!");
                    break;
                }
            }
        }

        public static char operation() {
            System.out.println("Введите операцию (+, -, *, /): ");
            char op = scanner.next().charAt(0);
            if (op == '+' || op == '-' || op == '*' || op == '/') {
                return op;
            } else {
                throw new IllegalArgumentException("Некорректная операция!");
            }
        }

        public static void calc(Stack<Integer> st, Character op) {
            double b = st.pop();
            double a = st.peek();
            double res = 0;
            if (b == 0 && op == '/') {
                System.out.println("Делить на 0 нельзя");
            } else {
                switch (op) {
                    case '+' -> res = a + b;
                    case '-' -> res = a - b;
                    case '*' -> res = a * b;
                    case '/' -> res = a / b;
                }
                System.out.println("Решение: " + a + " " + op + " " + b + " = " + res);
            }
        }
    }
package Lesson_14_junit_5;
//Задание 14:
//Создайте 2 ветки: Lesson_14_junit_5 и Lesson_14_testng.
//Напишите программу, позволяющую вычислить факториал числа. Эта программа должна быть в каждой ветке.
//В ветке Lesson_14_junit_5 напишите юнит-тесты для этой программы, используя Junit 5.
//В ветке Lesson_14_testng напишите юнит-тесты, используя TestNG.
public class Factorial {
        public static long factorial(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Факториал не определен для отрицательных чисел");
            } else if (n == 0 || n == 1) {
                return 1;
            } else {
                long result = 1;
                for (int i = 2; i <= n; i++) {
                    result *= i;
                }
                return result;
            }
        }

        public static void main(String[] args) {
            int num = 5;
            long factorialResult = factorial(num);
            System.out.println("Факториал числа " + num + " равен " + factorialResult);
        }
    }

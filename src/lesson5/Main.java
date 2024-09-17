package lesson5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        sumRange();
        checkNumber();
        initiateNumber();
        printStringMultiple();
        LeapYear();
        changeMassive();
        createMassive();
        multipleMassive();
        fillDiagonal();
        returnMassive();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 2;
        int b = 3;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = -100;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 4;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void sumRange() {
        int a = 11;
        int b = 3;
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void checkNumber() {
        int num = -1;
        if (num >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static void initiateNumber() {
        int num = 1;
        if (num >= 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    public static void printStringMultiple() {
        for (int i = 0; i < 2; i++) {
            System.out.println("str");
        }
    }

    public static boolean LeapYear() {
        int year = 400;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        return false;
    }

    private static void changeMassive() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void createMassive() {
        int[] array = new int[100];
        int value = 1;
        for(int i = 0; i<array.length;i++)
        {
            array[i] = value;
            value += 1;
        }
        System.out.println(Arrays.toString(array));
    }
    private static void multipleMassive() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    private static void fillDiagonal() {
        int size = 2;
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
            array[i][size - i - 1] = 1;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
    public static void returnMassive(){
        int len = 3;
        int initialValue = 2;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
            System.out.print("[" + i + "]" + arr[i] + " ");
        }
    }
}

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
    // 1. Создайте метод printThreeWords(), который при вызове
    // должен отпечатать в столбец три слова: Orange, Banana, Apple.
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    // 2. Создайте метод checkSumSign(), в теле которого объявите две int
    // переменные a и b и инициализируйте их любыми значениями, которыми захотите.
    // Далее метод должен просуммировать эти переменные и если их сумма больше или равна 0,
    // то вывести в консоль сообщение "Сумма положительная", в противном случае - "Сумма отрицательная".
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
    // 3. Создайте метод printColor() в теле которого задайте int переменную value меньше 0 (0 включительно),
    // то в консоль метод должен вывести сообщение "Красный", если лежит в пределах от 0 (0 исключительно)
    // до 100 (100 включительно), то "Желтый", если больше 100 (100 исключительно) - "Зеленый".
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
    // 4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b и
    // инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b, то необходимо
    // вывести в консоль сообщение "a >= b", в противном случае "a < b".
    public static void compareNumbers() {
        int a = 4;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    // 5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
    // от 10 до 20 (включительно), если да - вернуть true, в противном случае - false.
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
    // 6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать
    // в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void checkNumber() {
        int num = -1;
        if (num >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }
    // 7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    // если число отрицательное и вернуть false если положительное. Замечание: ноль считаем положительным числом.
    public static void initiateNumber() {
        int num = 1;
        if (num >= 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
    // 8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать
    // в консоль указанную строку, указанное количество раз.
    public static void printStringMultiple() {
        for (int i = 0; i < 2; i++) {
            System.out.println("str");
        }
    }
    // 9. Напишите метод, который определяет, является ли год високосным и возвращает boolean (високосный - true,
    // не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом
    // каждый 400-й - високосный.
    public static boolean LeapYear() {
        int year = 400;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        return false;
    }
    // 10. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0.
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
    // 11. Задать целочисленный массив длинной 100. С помощью цикла заполнить
    // его значениями 12345678...100.
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
    // 12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом
    // и числа, меньшие 6, умножить на 2.
    private static void multipleMassive() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    // 13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов)
    // заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
    // Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов
    // равны, то есть [0][0], [2][2], ..., [n][n].
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
    // 14. написать метод, принимающий на вход два аргумента: len и initialValue и возвращающий
    // одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
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

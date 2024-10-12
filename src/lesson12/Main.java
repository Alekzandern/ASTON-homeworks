package lesson12;

//1. Задание:
//Напишите метод, на вход которого подаётся двумерный строковый
//массив размером 4х4. При подаче массива другого размера
//необходимо бросить исключение Myarraysizeexception
//2. Задание:
//Далее метод должен пройтись по всем элементам массива,
//преобразовать в int и просуммировать. Если в каком-то элементе
//массива преобразование не удалось (например, в ячейке лежит
//символ или текст вместо числа), должно быть брошено исключение
//MyArrayDataException с детализацией, в какой именно ячейке лежат
//неверные данные.
//3. Задание:
//В методе main() вызвать полученный метод, обработать возможные
//исключения MyArraySizeException и MyArrayDataException и
//вывести результат расчета.

public class Main {
    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array == null) {
            throw new NullPointerException("Массив не может быть null");
        }

        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4");
        }

        for (String[] row : array) {
            if (row == null || row.length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Невозможно преобразовать значение в ячейке [" + i + "][" + j + "] в число");
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArray(array);
            System.out.println("Результат расчета: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных массива: " + e.getMessage());
        }

        String[][] arrayWrong = new String[][]{
                {"1", "2", "three", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            sumArray(arrayWrong);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных массива: " + e.getMessage());
        }
    }
}

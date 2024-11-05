package lesson10;

//Задание 1
//Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//Конструктор класса должен заполнять эти поля при создании объекта.
//Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.

public class Main {
    public static void main(String[] args) {
        Park.Attraction[] attractions = new Park.Attraction[5];
        attractions[0] = new Park.Attraction("Аттракцион1", "1Аттракцион", "9:00-19:00", 15.0);
        attractions[1] = new Park.Attraction("Аттракцион2", "2Аттракцион", "9:00-20:00", 20.0);
        attractions[2] = new Park.Attraction("Аттракцион3", "3Аттракцион", "10:00-18:00", 10.0);
        attractions[3] = new Park.Attraction("Аттракцион4", "4Аттракцион", "11:00-17:00", 12.0);
        attractions[4] = new Park.Attraction("Аттракцион5", "5Аттракцион", "12:00-16:00", 18.0);
        Park park = new Park(attractions);
        park.printAttractions();
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Иван", "Иванов", "Менеджер", "ivanov@.com", "+79123456790", 50000, 22);
        persArray[1] = new Employee("Петр", "Петров", "Инженер", "petrov@.com", "+79123456790", 40000, 33);
        persArray[2] = new Employee("Сидор", "Сидоров", "Специалист", "sidorov@.com", "+79123456791", 35000, 44);
        persArray[3] = new Employee("Кузнец", "Кузнецов", "Специалист", "kuznetsov@.com", "+79123456792", 32000, 55);
        persArray[4] = new Employee("Федор", "Федоров", "Менеджер", "Fedarov@.com", "+79123456793", 50000, 66);
        for (Employee employee : persArray) {
            employee.printInfo();
        }
    }
}
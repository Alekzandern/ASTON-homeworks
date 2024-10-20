package Lesson13;

import java.util.*;

//2. Задание:
//Написать простой класс Телефонный Справочник, который хранит в
//себе список фамилий и телефонных номеров. В этот телефонный
//справочник с помощью метода add() можно добавлять записи, а с
//помощью метода get() искать номер телефона по фамилии. Следует
//учесть, что под одной фамилией может быть несколько телефонов
//(в случае однофамильцев), тогда при запросе такой фамилии
//должны выводиться все телефоны.
public class PhoneBook {
    private final Map<String, List<String>> phoneBook;
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (!phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new ArrayList<>());
        }
        phoneBook.get(lastName).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "8-123-123-45-67");
        phoneBook.add("Петров", "8-321-987-65-43");
        phoneBook.add("Сидоров", "8-234-555-12-34");
        phoneBook.add("Иванов", "8-543-777-88-99");

        System.out.println("Телефон(ы) Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Телефон(ы) Петрова: " + phoneBook.get("Петров"));
        System.out.println("Телефон(ы) Сидорова: " + phoneBook.get("Сидоров"));
    }
}

package Lesson13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//1. Задание:
//Создать массив с набором слов (10-20 слов, должны встречаться
//повторяющиеся). Найти и вывести список уникальных слов, из
//которых состоит массив (дубликаты не считаем). Посчитать,
//сколько раз встречается каждое слово. (реализовать с
//использованием коллекций)
public class Main {
    public static class UniqueWordsCounter {

        public static void main(String[] args) {
            String[] words = {
                    "pen", "ape", "milk", "apple", "cat",
                    "ape", "dog", "milk", "mango", "apple",
                    "cat", "dog", "house", "pen"
            };

            Set<String> uniqueWords = new HashSet<>();

            Map<String, Integer> wordCounts = new HashMap<>();

            for (String word : words) {
                uniqueWords.add(word);
                if (wordCounts.containsKey(word)) {
                    wordCounts.put(word, wordCounts.get(word) + 1);
                } else {
                    wordCounts.put(word, 1);
                }
            }
            System.out.println("Уникальные слова:");
            for (String word : uniqueWords) {
                System.out.println(word);
            }

            System.out.println("\nКоличество каждого слова:");
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}

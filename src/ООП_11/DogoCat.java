

        //Задание 1:
        //Создать классы Собака и Кот с наследованием от класса Животное.
        //Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина
        //препятствия. Результатом выполнения действия будет печать в консоль. (Например,
        //dogBobik.run(150); "Бобик пробежал 150 м.);
        //У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не
        //умеет плавать, собака 10 м.).
        //Добавить подсчет созданных котов, собак и животных.

        //Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты:
        //Сделать так, чтобы в миске с едой не могли получиться отрицательного
        //количества еды
        //(например, в миске 10 еды, а кот пытается покушать 15-20).
        //Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
        //Если коту удалось покушать (хватило еды), сытость = true.
        //Считаем, что если коту мало еды в миске, то он её просто не трогает, то есть не может быть
        //наполовину сыт (это сделано для упрощения логики программы).
        //Создать массив котов и миску с едой, попросить всех котов покушать из этой миски и потом
        //вывести информацию о сытости котов в консоль.
        //Добавить метод, с помощью которого можно было бы добавлять еду в миску.
public class DogoCat {
            private final int runDistance;
            private final int swimDistance;

            public DogoCat(int runDistance, int swimDistance) {
                this.runDistance = runDistance;
                this.swimDistance = swimDistance;
            }

            public void run(int distance) {
                if (distance <= runDistance) {
                    System.out.println("Выполнил пробежку " + distance + "м.");
                } else {
                    System.out.println("Пробежать " + distance + "м. невозможно.");
                }
            }

            public void swim(int distance) {
                if (distance <= swimDistance) {
                    System.out.println("Выполнил плавание " + distance + "м.");
                } else {
                    System.out.println("Плавать " + distance + "м. невозможно.");
                }
            }
        }

        class Dog extends DogoCat {
            public Dog() {
                super(500, 10);

            }
        }

        class Cat extends DogoCat {
            public int satiety;
            private int eating;

            public Cat() {
                super(200, 0);
                this.eating = 10;
                this.satiety = 0;
            }

            public void setEating() {
                if (eating >= 5) {
                    satiety = 1;
                    eating -= 5;
                    System.out.println("Кот поел.");
                } else {
                    System.out.println("В миске мало еды.");
                }
            }

            public void addEating(int eating) {
                if (this.eating + eating >= 0) {
                    this.eating += eating;
                    System.out.println("Добавлено еды.");
                } else {
                    System.out.println("В миске слишком много еды.");
                }
            }
        }

        class Main {
            public static void main(String[] args) {
                Dog dogBobik = new Dog();
                dogBobik.run(150);
                dogBobik.swim(5);

                Cat[] cat = new Cat[5];
                for (int i = 0; i < 5; i++) {
                    cat[i] = new Cat();
                }

                for (int i = 0; i < 5; i++) {
                    cat[i].setEating();
                }

                for (int i = 0; i < 5; i++) {
                    System.out.println("Кот " + i + " сыт: " + (cat[i].satiety == 1? "да" : "нет"));
                }

                for (int i = 0; i < 5; i++) {
                    cat[i].addEating(5);
                }

                for (int i = 0; i < 5; i++) {
                    cat[i].setEating();
                }

                for (int i = 0; i < 5; i++) {
                    System.out.println("Кот " + i + " сыт: " + (cat[i].satiety == 1? "да" : "нет"));
                }
            }
        }
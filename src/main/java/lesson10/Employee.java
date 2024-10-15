package main.java.lesson10;

//Задание 2
//Создать массив из 5 сотрудников.
//Пример:
//вначале объявляем массив объектов
//Person[I persArray = new Person[5];
// потом для каждой ячейки массива задаем объект
//persArray[01 = new Person ("Ivanov Ivan", "Engineer",
//"ivivan@mailbox.com", "892312312", 30000, 30);
//persArray[1] = new Person(...);
//persArray[4] = new Person(...);

public class Employee {
    public static void main(String[] args) {
        class employee {
            private String firstName;
            private String lastName ;
            private String post;
            private String email;
            private String tel;
            private double salary;
            private int age;

            public employee(String firstName, String lastName, String post, String email, String tel, int salary, int age) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.post = post;
                this.email = email;
                this.tel = tel;
                this.salary = salary;
                this.age = age;
            }
        }
        employee[] persArray = new employee[5];

                persArray[0] = new employee("Иван", "Иванов", "Менеджер", "ivanov@.com", "+79123456790", 50000, 22);
                persArray[1] = new employee("Петр", "Петров", "Инженер", "petrov@.com", "+79123456790", 40000, 33);
                persArray[2] = new employee("Сидор", "Сидоров", "Специалист", "sidorov@.com", "+79123456791", 35000, 44);
                persArray[3] = new employee("Кузнец", "Кузнецов", "Специалист", "kuznetsov@.com", "+79123456792", 32000, 55);
                persArray[4] = new employee("Федор", "Федоров", "Менеджер", "ivanov@.com", "+79123456793", 50000, 66);

                for (int i = 0; i < persArray.length; i++) {
                    System.out.println("Сотрудник " + (i + 1));
                    System.out.println("Имя: " + persArray[i].firstName);
                    System.out.println("Фамилия: " + persArray[i].lastName);
                    System.out.println("Должность: " + persArray[i].post);
                    System.out.println("Email: " + persArray[i].email);
                    System.out.println("Телефон: " + persArray[i].tel);
                    System.out.println("Зарплата: " + persArray[i].salary);
                    System.out.println("Возраст: " + persArray[i].age);
                    System.out.println();
                }
            }
        }



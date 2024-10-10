package lesson10;

public class Main {
    public static void main(String[] args) {
        class Employee {

            private String firstName;
            private String lastName;
            private String post;
            private String email;
            private String tel;
            private double salary;
            private int age;

            public Employee(String firstName, String lastName, String post, String email, String tel, int salary, int age) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.post = post;
                this.email = email;
                this.tel = tel;
                this.salary = salary;
                this.age = age;
            }
        }

        Employee[] persArray = new Employee[1];
        persArray[0] = new Employee("Иван", "Иванов", "Менеджер", "ivanov@.com", "+79123456790", 50000, 22);
        for (int i = 0; i < persArray.length; i++) {
            System.out.println("Имя: " + persArray[i].firstName);
            System.out.println("Фамилия: " + persArray[i].lastName);
            System.out.println("Должность: " + persArray[i].post);
            System.out.println("Email: " + persArray[i].email);
            System.out.println("Телефон: " + persArray[i].tel);
            System.out.println("Зарплата: " + persArray[i].salary);
            System.out.println("Возраст: " + persArray[i].age);

        }
    }
}

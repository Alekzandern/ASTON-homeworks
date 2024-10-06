// Создать класс "Сотрудник" с полями: "ФИО"; должность; емэйл; телефон; зарплата; возраст.
// Конструктор должен заполнять эти поля при создании объекта.
// Внутри класса "Сотрудник" написать метод, который выводит информацию об объекте в консоль.
public class OnePerson {
    public static void main(String[] args) {
        class Сотрудник {

            public String ФИО;
            public String должность;
            public String емэйл;
            public String телефон;
            public int зарплата;
            public int возраст;

            public Сотрудник(String ФИО, String должность, String емэйл, String телефон, int зарплата, int возраст) {
                this.ФИО = ФИО;
                this.должность = должность;
                this.емэйл = емэйл;
                this.телефон = телефон;
                this.зарплата = зарплата;
                this.возраст = возраст;
            }
        }

        class EmployeePrinter {
            public void printEmployeeDetails(Сотрудник сотрудник) {
                System.out.println("ФИО: " + сотрудник.ФИО);
                System.out.println("Должность: " + сотрудник.должность);
                System.out.println("Email: " + сотрудник.емэйл);
                System.out.println("Телефон: " + сотрудник.телефон);
                System.out.println("Зарплата: " + сотрудник.зарплата);
                System.out.println("Возраст: " + сотрудник.возраст);
            }
        }

        Сотрудник сотрудник1 = new Сотрудник("Иванов Иван Иванович", "Тестер",
                "ivanov@.com", "+79123456789", 900000, 40);

        EmployeePrinter printer = new EmployeePrinter();
        printer.printEmployeeDetails(сотрудник1);
    }
}

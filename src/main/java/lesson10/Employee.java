package lesson10;

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

    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        for (int i = 0; i < persArray.length; i++) {
            System.out.println("Сотрудник " + (i + 1));
        persArray[0] = new Employee("Иван", "Иванов", "Менеджер", "ivanov@.com", "+79123456790", 50000, 22);
        persArray[1] = new Employee("Петр", "Петров", "Инженер", "petrov@.com", "+79123456790", 40000, 33);
        persArray[2] = new Employee("Сидор", "Сидоров", "Специалист", "sidorov@.com", "+79123456791", 35000, 44);
        persArray[3] = new Employee("Кузнец", "Кузнецов", "Специалист", "kuznetsov@.com", "+79123456792", 32000, 55);
        persArray[4] = new Employee("Федор", "Федоров", "Менеджер", "Fedarov@.com", "+79123456793", 50000, 66);
            persArray[i].printInfo();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Имя: " + firstName);
        System.out.println("Фамилия: " + lastName);
        System.out.println("Должность: " + post);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + tel);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println();
    }
}
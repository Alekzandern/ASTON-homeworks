// Создать массив из 5 сотрудников. (я так понял как 1 задание, только 5 сотрудников).
public class FivePersons {
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
                Сотрудник[] persArray = new Сотрудник[5];

                persArray[0] = new Сотрудник("Иванов Иван Иванович", "Менеджер", "ivanov@.com", "+79123456789", 50000, 30);
                persArray[1] = new Сотрудник("Петров Петр Петрович", "Инженер", "petrov@.com", "+79123456790", 40000, 35);
                persArray[2] = new Сотрудник("Сидоров Сергей Сергеевич", "Специалист", "sidorov@.com", "+79123456791", 35000, 25);
                persArray[3] = new Сотрудник("Кузнецов Кирилл Кириллович", "Специалист", "kuznetsov@.com", "+79123456792", 32000, 28);
                persArray[4] = new Сотрудник("Иванов Иван Иванович", "Менеджер", "ivanov@.com", "+79123456793", 50000, 30);

                for (int i = 0; i < persArray.length; i++) {
                    System.out.println("Сотрудник " + (i + 1));
                    System.out.println("ФИО: " + persArray[i].ФИО);
                    System.out.println("Должность: " + persArray[i].должность);
                    System.out.println("Email: " + persArray[i].емэйл);
                    System.out.println("Телефон: " + persArray[i].телефон);
                    System.out.println("Зарплата: " + persArray[i].зарплата);
                    System.out.println("Возраст: " + persArray[i].возраст);
                    System.out.println();
                }
            }
        }



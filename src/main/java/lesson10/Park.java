package lesson10;

// Задание 3
//Создать класс Park с внутренним классом, с помощью объектов которого можно хранить
//информацию об аттракционах, времени их работы и стоимости.

public class Park {
    private final Attraction[] attractions;

    public Park(Attraction[] attractions) {
        this.attractions = attractions;
    }

    public static void main(String[] args) {
        Attraction[] attractions = new Attraction[5];
        attractions[0] = new Park.Attraction("Аттракцион1", "1Аттракцион", "9:00-19:00", 15.0);
        attractions[1] = new Park.Attraction("Аттракцион2", "2Аттракцион", "9:00-20:00", 20.0);
        attractions[2] = new Park.Attraction("Аттракцион3", "3Аттракцион", "10:00-18:00", 10.0);
        attractions[3] = new Park.Attraction("Аттракцион4", "4Аттракцион", "11:00-17:00", 12.0);
        attractions[4] = new Park.Attraction("Аттракцион5", "5Аттракцион", "12:00-16:00", 18.0);
        Park park = new Park(attractions);
        park.printAttractions();
    }

    public void printAttractions() {
        for (int i = 0; i < attractions.length; i++) {
            System.out.println("Аттракцион " + (i + 1));
            System.out.println("Название: " + attractions[i].getName());
            System.out.println("Тип: " + attractions[i].getType());
            System.out.println("Время работы: " + attractions[i].getOperatingHours());
            System.out.println("Стоимость: " + attractions[i].getCost());
            System.out.println();
        }
    }

    static class Attraction {
        private final String name;
        private final String type;
        private final String operatingHours;
        private final double cost;

        Attraction(String name, String type, String operatingHours, double cost) {
            this.name = name;
            this.type = type;
            this.operatingHours = operatingHours;
            this.cost = cost;
        }

        private String getName() {
            return name;
        }

        private String getType() {
            return type;
        }

        private String getOperatingHours() {
            return operatingHours;
        }

        private double getCost() {
            return cost;
        }
    }
}
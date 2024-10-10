package lesson10;

public class Park {
        private static class Attraction {
            private String name;
            private String type;
            private String operatingHours;
            private double cost;

            private Attraction(String name, String type, String operatingHours, double cost) {
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

        private Attraction[] attractions;

        private Park(Attraction[] attractions) {
            this.attractions = attractions;
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

        public static void main(String[] args) {
            Attraction[] attractions = new Attraction[5];

            attractions[0] = new Attraction("Атракцион1", "1Атракцион", "9:00-19:00", 15.0);
            attractions[1] = new Attraction("Атракцион2", "2Атракцион", "9:00-20:00", 20.0);
            attractions[2] = new Attraction("Атракцион3", "3Атракцион", "10:00-18:00", 10.0);
            attractions[3] = new Attraction("Атракцион4", "4Атракцион", "11:00-17:00", 12.0);
            attractions[4] = new Attraction("Атракцион5", "5Атракцион", "12:00-16:00", 18.0);

            Park park = new Park(attractions);
            park.printAttractions();
        }
    }


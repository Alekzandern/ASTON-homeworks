        //Задание 2:
        //Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур:
        //круг, прямоугольник, треугольник.
        //Задать для каждой фигуры цвет заливки и цвет границы.
        //Результат полученных характеристик [Периметр, площадь, цвет фона, цвет границ] по каждой
        //фигуре вывести в консоль.
        //Попробуйте реализовать базовые методы, такие как расчет периметра фигур, в качестве дефолтных
        //методов в интерфейсе.

public class Figures {
    interface Shape {
        default double calculatePerimeter() {
            return 0;
        }

        default double calculateArea() {
            return 0;
        }

        void printCharacteristics();
    }

    static class Circle implements Shape {
        private double radius;
        private String fillColor;
        private String borderColor;

        public Circle(double radius, String fillColor, String borderColor) {
            this.radius = radius;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public void printCharacteristics() {
            System.out.println("Circle: ");
            System.out.println("Perimeter: " + calculatePerimeter());
            System.out.println("Area: " + calculateArea());
            System.out.println("Fill Color: " + fillColor);
            System.out.println("Border Color: " + borderColor);
        }
    }

    static class Rectangle implements Shape {
        private double width;
        private double height;
        private String fillColor;
        private String borderColor;

        public Rectangle(double width, double height, String fillColor, String borderColor) {
            this.width = width;
            this.height = height;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        @Override
        public double calculateArea() {
            return width * height;
        }

        @Override
        public void printCharacteristics() {
            System.out.println("Rectangle: ");
            System.out.println("Perimeter: " + calculatePerimeter());
            System.out.println("Area: " + calculateArea());
            System.out.println("Fill Color: " + fillColor);
            System.out.println("Border Color: " + borderColor);
        }
    }

    static class Triangle implements Shape {
        private double a;
        private double b;
        private double c;
        private String fillColor;
        private String borderColor;

        public Triangle(double a, double b, double c, String fillColor, String borderColor) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculatePerimeter() {
            return a + b + c;
        }

        @Override
        public double calculateArea() {
            double s = calculatePerimeter() / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        @Override
        public void printCharacteristics() {
            System.out.println("Triangle: ");
            System.out.println("Perimeter: " + calculatePerimeter());
            System.out.println("Area: " + calculateArea());
            System.out.println("Fill Color: " + fillColor);
            System.out.println("Border Color: " + borderColor);
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Circle circle = new Circle(5, "red", "black");
            Rectangle rectangle = new Rectangle(4, 6, "blue", "green");
            Triangle triangle = new Triangle(3, 4, 5, "yellow", "purple");

            circle.printCharacteristics();
            System.out.println();
            rectangle.printCharacteristics();
            System.out.println();
            triangle.printCharacteristics();
        }
    }
}

abstract class Shape {

    abstract double area();

    abstract double perimeter();
}

class Circle extends Shape {

    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {

    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape {

    private double side1;
    private double side2;
    private double side3;

    Triangle(double side1, double side2, double side3) {

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double area() {

        double s = perimeter() / 2;

        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double perimeter() {

        return side1 + side2 + side3;
    }
}

public class ShapeHierarchy {

    public static void main(String[] args) {

        Shape[] shapes = {

                new Circle(5),
                new Rectangle(8, 4),
                new Triangle(3, 4, 5)
        };

        System.out.printf("%-12s %-12s %-12s%n",
                "Shape", "Area", "Perimeter");

        for (Shape shape : shapes) {

            System.out.printf("%-12s %-12.2f %-12.2f%n",
                    shape.getClass().getSimpleName(),
                    shape.area(),
                    shape.perimeter());
        }
    }
}
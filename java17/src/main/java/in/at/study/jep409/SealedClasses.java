package in.at.study.jep409;
/**
 * <a href="https://openjdk.org/jeps/409">JEP-409</a>
 */
public class SealedClasses {

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();

        detectShape(circle);
        detectShape(square);
    }

    private static void detectShape(Shape shape) {
        switch (shape) {
            case Circle c -> System.out.println(c.getName());
            case Square s -> System.out.println(s.getName() + " has " + s.corners() + " corners.");
            default -> System.out.println("Unknown shape?!");
        }
    }
}

sealed interface Shape permits Circle, Square {
    String getName();
}

non-sealed class Circle implements Shape {

    @Override
    public String getName() {
        return "Circle";
    }
}

non-sealed class Square implements Shape {

    @Override
    public String getName() {
        return "Square";
    }

    public int corners() {
        return 4;
    }

}

//non-sealed class Rectangle implements Shape {} // Compile time error.
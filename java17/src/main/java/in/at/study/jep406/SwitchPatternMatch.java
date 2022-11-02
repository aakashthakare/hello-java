package in.at.study.jep406;
/**
 * <a href="https://openjdk.org/jeps/406">JEP-406</a>
 */
public class SwitchPatternMatch {

    static record Dog (String name, Integer age) {}

    static record Cat (String name, Integer age) {}

    public static void main(String[] args) {
        Object tyson = new Dog("Tyson", 10);
        Object mini = new Cat("Mini", 10);

        detectAnimal(tyson);
        detectAnimal(mini);
        detectAnimal(null);
        detectAnimal(new Object());

        Dog tommy = new Dog("Tommy", 10);
        Dog mike = new Dog("Mike", 2);

        System.out.println(String.format("Is %s older than 5 years? : %s", tommy.name, isDogOlderThan5Years(tommy)));
        System.out.println(String.format("Is %s older than 5 years? : %s", mike.name, isDogOlderThan5Years(mike)));

        //isDogOlderThan5Years(mini); #Exception
    }

    public static void detectAnimal(Object obj) {
        switch (obj) {
            case Dog d -> System.out.println("It's a dog.");
            case Cat c -> System.out.println("It's a cat.");
            case null -> System.out.println("No animal.");
            default -> System.out.println("Unknown animal?!");
        }
    }

    public static boolean isDogOlderThan5Years(Object obj) {
        return switch (obj) {
            case Dog d && d.age >= 5 -> true;
            case Dog d && d.age < 5 -> false;
            default -> throw new IllegalArgumentException("It's not a dog!");
        };
    }
}



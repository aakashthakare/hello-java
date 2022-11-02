package in.at.study.jep356;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.IntStream;

/**
 * <a href="https://openjdk.org/jeps/356">JEP-356</a>
 */
public class EnhancedRandomGenerator {

    public static void main(String[] args) {
        RandomGenerator randomGenerator = RandomGeneratorFactory.of("Xoshiro256PlusPlus").create();

        IntStream.range(0, 101).forEach(i -> {
                System.out.println(randomGenerator.nextInt(10));
        });

        System.out.println("Available algorithms:");
        RandomGeneratorFactory.all().map(a -> a.name()).sorted().forEach(System.out::println);
    }
}

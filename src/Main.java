import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1");

        Predicate<Integer>naturalNumber=new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number>0;
            }
        };
        System.out.println(naturalNumber.test(5));
        System.out.println(naturalNumber.test(-5));
        System.out.println("---");

        Predicate<Integer> naturalNumber1 = number -> number > 0;
        System.out.println(naturalNumber1.test(-6));
        System.out.println(naturalNumber1.test(6));
        System.out.println("---");

        System.out.println("Задание 2");
        Consumer<String> greetings = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("привет " + name);
            }
        };
        greetings.accept("Иван");
        System.out.println("---");

        Consumer<String> greeting1 = s -> System.out.println("привет " + s);
        greeting1.accept("Иван");

        System.out.println("Задание 3");
        Function<Double, Long> roundedOffLong = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(roundedOffLong.apply(13.1415));
        System.out.println("---");

        Function<Double, Long> roundedOffLong1 = aDouble -> Math.round(aDouble);
        System.out.println(roundedOffLong1.apply(13.1415));

        System.out.println("Задание 4");
        Supplier<Integer> randomNumber = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(100);
            }
        };
        System.out.println(randomNumber.get());
        System.out.println("---");
        Supplier<Integer> randomNumber1 = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };
        System.out.println(randomNumber1.get());

        System.out.println("Задание 5");
        Function<Integer, Integer> multiplyToThree = x -> x * 3;
        Function<Integer, Integer> multiplyToFour = x -> x * 4;
        Predicate<Integer> isOdd = x -> x % 2 != 0;
        Function<Integer, Integer> result;
        result = ternaryOperator(isOdd, multiplyToFour, multiplyToThree);
        result.apply(-20);
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> {
            U result = condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
            System.out.println(result);
            return result;
        };

    }
}
package homework10;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        Predicate<Double> isNumberPositive = new Predicate<Double>() {
            public boolean test(Double number) {
                return number > 0;
            }
        };
        System.out.println(isNumberPositive.test(-2.3));
        System.out.println(isNumberPositive.test(2.3));

        Predicate<Double> isNumberPositive1 = number -> number > 0;
        System.out.println(isNumberPositive.test(-2.3));
        System.out.println(isNumberPositive.test(2.3));
        System.out.println();

        System.out.println("Задание 2");
        Consumer<String> greeting = new Consumer<String>() {
            public void accept(String name) {
                System.out.println("Привет, " + name);
            }
        };
        greeting.accept("Мэри");
        Consumer<String> greeting1 = name -> System.out.println("Привет, " + name);
        greeting1.accept("Элис");
        System.out.println();

        System.out.println("Задание 3");
        Function<Double, Long> roundNumber = new Function<Double, Long>() {
            @Override
            public Long apply(Double number) {
                return Math.round(number);
            }
        };
        System.out.println(roundNumber.apply(5.99999999));
        Function<Double, Long> roundNumber1 = number -> Math.round(number);
        System.out.println(roundNumber1.apply(9.99999999));

        System.out.println();

        System.out.println("Задание 4");
        Supplier<Integer> randomNumber = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(100);
            }
        };
        System.out.println(randomNumber.get());
        Supplier<Integer> randomNumber1 = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };
        System.out.println(randomNumber1.get());
        System.out.println();

        System.out.println("Задание 5");
        Function<Integer, Integer> ifTrue = x -> x * 2;
        Function<Integer, Integer> ifFalse = x -> (x * -1) * 2;
        Predicate<Integer> condition = x -> x > 0;
        Function<Integer, Integer> result = ternaryOperator(condition, ifTrue, ifFalse);
        result.apply(-5);
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

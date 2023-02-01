package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(8);
        integerList.add(11);
        integerList.add(30);
        integerList.add(15);
        integerList.add(7);
        integerList.add(24);
        integerList.add(5);
        integerList.add(16);
        Stream<Integer> integerStream = integerList.stream();
        findMinmax(integerStream, Integer::compareTo,
                (x, y) -> System.out.println("Минимальное значение  " + x + " , " + "максимальное значение  " + y));


        System.out.println("Задание 2");

        countEvenNumbers(integerList);
    }

    public static <T> void findMinmax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> arrayList;
        T min = null;
        T max = null;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        }
        minMaxConsumer.accept(min, max);

    }

    public static void countEvenNumbers(List<Integer> list) {
        System.out.println("количество четных чисел : " + list.stream()
                .filter(x -> x % 2 == 0)
                .count());

    }
}





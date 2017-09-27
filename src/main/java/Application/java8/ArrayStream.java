package Application.java8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStream {


    public static void main(String[] args) {

        String[] strArray = {"a", "b", "c", "d", "e"};

        Stream<String> stream1 = Arrays.stream(strArray);
        stream1.forEach(System.out::print);

        System.out.println();

        Stream<String> stream2 = Stream.of(strArray);
        stream2.forEach(System.out::print);

        System.out.println("\n---primitve array---");

        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intStream1 = Arrays.stream(intArray);
        intStream1.forEach(System.out::print);

        System.out.println();
        Stream<int[]> stream = Stream.of(intArray);
        IntStream intStream2 = stream.flatMapToInt(x -> Arrays.stream(x));
        intStream2.forEach(System.out::print);


    }
}

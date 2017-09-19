package Application.DSA;

import java.util.stream.IntStream;

public class LonelyInteger {

    public int findLonelyInteger(int[] input) {

        return IntStream
                .range(0, input.length)
                .map(i -> input[i])
                .reduce((x, y) -> x ^= y)
                .getAsInt();
    }
}

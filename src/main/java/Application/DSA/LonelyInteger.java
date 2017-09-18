package Application.DSA;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LonelyInteger {

    public int findLonelyInteger(int[] input) {

        int result=0;

        Arrays.stream(input).
        IntStream.range(0, input.length).map(i -> result^=input[i]);
    }
}

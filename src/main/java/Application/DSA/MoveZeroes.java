package Application.DSA;

import java.util.Arrays;

public class MoveZeroes {


    public static void main(String[] args) {

        Integer[] input = {0    , 6};
        System.out.println(Arrays.toString(new MoveZeroes().moveZeroes(input)));
    }

    private Integer[] moveZeroes(Integer[] input) {

        if (null == input)
            return new Integer[]{};

        int s = 0;
        int e = input.length - 1;
        while (!(s >= e)) {

            if (input[s] != 0) {
                s++;
                continue;
            }
            if (input[e] == 0) {
                e--;
                continue;
            }

            if (input[s] == 0) {
                input[s] = input[e];
                input[e] = 0;
                e--;
                s++;
            }

        }


        return input;
    }
}

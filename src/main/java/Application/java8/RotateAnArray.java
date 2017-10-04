package Application.java8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RotateAnArray {

    public static void main(String[] args) {
        RotateAnArray r = new RotateAnArray();
        System.out.println(Arrays.toString(r.solution(new int[]{1, 2, 3, 4, 5}, 18)));

    }


    public int[] solution(int[] A, int k) {


        int length = A.length;

        if(length==0)
            return A;

        if (k > length) {
            k = k % length;
        }

        if (k == 0)
            return A;
        int rotateK = k;
        int[] arr = new int[length];

        IntStream.range(0, length).forEach(i -> {
            int nextIndex = ((rotateK + i) < length) ? i + rotateK : i + rotateK - length;

            arr[nextIndex] = A[i];


        });


        return arr;
    }

}

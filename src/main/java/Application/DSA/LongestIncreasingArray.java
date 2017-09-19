package Application.DSA;

import java.util.stream.IntStream;

public class LongestIncreasingArray {


    public int longestIncreasingArray(int[] input) {

        if(null == input || 0 == input.length)
            return -1;

        int currMax = 0;
        int count = 1;

        for (int i = 0; i < input.length-1; i++) {
            if(input[i] > input[i+1]){
                if(currMax<count)
                    currMax = count;
                count = 1;
            }else {
                count++;
            }
        }

//        IntStream.range(0,input.length-1).

        if(currMax<count)
            currMax=count;

        return currMax;

    }
}

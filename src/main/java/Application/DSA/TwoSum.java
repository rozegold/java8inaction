package Application.DSA;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoSum {

//    2,7,11,15

    int[] findTwoSum(int[] inputArr, int target) {

        int[] result = new int[2];

        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        IntStream.range(0, inputArr.length)
                .filter(i -> !valueIndexMap.containsKey(inputArr[i]))
                .forEach(i -> valueIndexMap.put(target-inputArr[i],i));

        OptionalInt index =  IntStream.range(0, inputArr.length)
                .filter(i -> valueIndexMap.containsKey(inputArr[i]))
                .findFirst();

        result[0] = valueIndexMap.get(inputArr[index.getAsInt()]);
        result[1] = index.getAsInt();

        return result;
    }
}

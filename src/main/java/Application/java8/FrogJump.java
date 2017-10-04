package Application.java8;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FrogJump {

    public int solution(int X, int[] A) {

        if(A.length==0)
            return -1;

        Set<Integer> leafsSet = new HashSet<Integer>() {{

            IntStream.rangeClosed(1, X).forEach(this::add);
        }};

        int[] result = new int[1];

        IntStream.range(0, A.length).forEach(i -> {
            if (leafsSet.contains(A[i])) {
                leafsSet.remove(A[i]);
                if (leafsSet.size() == 0) {

                    result[0] = i;
                    return;
                }

            }
        });

        if(leafsSet.size()>0)
            return -1;

        return result[0];

    }

}

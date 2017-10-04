package Application.java8;

import java.util.Arrays;

public class LonelyElementInArray {


    public static void main(String[] args) {
        LonelyElementInArray l = new LonelyElementInArray();
        System.out.println(l.solution(new int[]{1,1,3,5,5}));
    }

        public int solution(int[] A) {


            return Arrays.stream(A)
                    .reduce((a,b) -> a^b).getAsInt();



        }

}

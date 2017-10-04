package Application.java8;

public class BinaryGapSolution {


    public static void main(String[] args) {

        BinaryGapSolution b = new BinaryGapSolution();

        System.out.println(b.solution(10));
    }


    public int solution(int N) {

        int count=0,maxCount = 0;


        String binary = Integer.toBinaryString(N);

        System.out.println(binary);

        for(char c : binary.toCharArray()){
            if(c == '1'){
                if(count>0){
                    maxCount = Math.max(maxCount,count);
                    count=0;
                }
            }else{
                count++;
            }
        }

        return maxCount;

    }
}
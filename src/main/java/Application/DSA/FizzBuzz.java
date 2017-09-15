package Application.DSA;

import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz f = new FizzBuzz();

        f.printFizzBuzz(20);


    }

    private void printFizzBuzz(int i) {
        if(i ==0 )
            return;

        IntStream.rangeClosed(1,i).forEach(num ->
            System.out.println((num%3==0)?(num%5==0?"FizzBuzz":"Fizz"):((num%5==0)?"Buzz":String.valueOf(num)))
        );

    }


}

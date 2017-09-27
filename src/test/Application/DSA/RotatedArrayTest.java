package Application.DSA;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class RotatedArrayTest {

    private RotatedArray subject;
    private int[] input = {10,20,1,3,6,7,8};
    @Before
    public void setUp() throws Exception {

        subject = new RotatedArray();
    }


    @Test
    public void shouldSearchIndexInRotatedArray(){
        assertEquals(0, subject.search(input, 10));
        assertEquals(1, subject.search(input, 20));
        assertEquals(2, subject.search(input, 1));
        assertEquals(3, subject.search(input, 3));
        assertEquals(4, subject.search(input, 6));
        assertEquals(5, subject.search(input, 7));
        assertEquals(6, subject.search(input, 8));

        System.out.println(IntStream.rangeClosed(1,10).reduce(0, Integer::sum));
        System.out.println(IntStream.rangeClosed(1,10).sum());

    }

}
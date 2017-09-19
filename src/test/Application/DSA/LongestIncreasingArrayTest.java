package Application.DSA;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingArrayTest {


    private LongestIncreasingArray subject;
    private int[] input = {1,3,2,3,4,8,7,9};
    @Before
    public void setUp() throws Exception {
        subject = new LongestIncreasingArray();
    }


    @Test
    public void testLongestIncArray(){
        assertEquals(4, subject.longestIncreasingArray(input));
    }

}
package Application.DSA;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingSubArrayTest {
    private LongestIncreasingSubArray subject;
    private int[] input = {1,3,2,3,4,8,7,9};
    @Before
    public void setUp() throws Exception {
        subject = new LongestIncreasingSubArray();
    }


    @Test
    public void testLongestIncSubArray(){
        assertEquals(4, subject.longestIncreasingSubarray(input));
    }



}
package Application.DSA;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {

    private TwoSum subject;

    int[] inputArr = {2,7,11,15};
    int target = 9;

    @Before
    public void setUp() throws Exception {
        subject = new TwoSum();
    }

    @Test
    public void findTwoSum() throws Exception {
            int[] result = subject.findTwoSum(inputArr, target);

            assertEquals(0, result[0]);
            assertEquals(1, result[1]);
    }

}
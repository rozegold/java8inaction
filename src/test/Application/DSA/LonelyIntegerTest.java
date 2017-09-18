package Application.DSA;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LonelyIntegerTest {

    private LonelyInteger subject;
    int[] input = {9,1,2,3,2,9,1,7,7};
    @Before
    public void setUp() throws Exception {
    subject =new LonelyInteger();
    }

    @Test
    public void shouldReturnLonelyInteger(){
        assertEquals(3, subject.findLonelyInteger(input));
    }

}
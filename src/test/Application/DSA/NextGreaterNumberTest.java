package Application.DSA;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NextGreaterNumberTest {


    private NextGreaterNumber subject;

    private Integer input = 423865;
    @Before
    public void setUp() throws Exception {

        subject = new NextGreaterNumber();

    }


    @Test
    public void testNextGreaterNumber(){
        assertEquals(425368,subject.nextGreaterNumber(input));
    }

}
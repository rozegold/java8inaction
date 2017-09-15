package Application.DSA;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {

    String first = "hello";
    String second = "billion";

    private Anagram subject;


    @Before
    public void setUp() throws Exception {

    subject = new Anagram();
    }


    @Test
    public void testHowManyCharactersToRemoveToMakeThemAnagram(){



        assertEquals(6, subject.howManyCharacterToMakeAnagram(first, second));
    }

}
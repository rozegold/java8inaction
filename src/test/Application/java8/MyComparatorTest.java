package Application.java8;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MyComparatorTest {


    private MyComparator subject;
    private List<Developer> devs;

    @Before
    public void setUp() throws Exception {
        subject = new MyComparator();
        devs = new ArrayList<>();
        devs.add(new Developer("b", 28, new BigDecimal(20000)));
        devs.add(new Developer("c", 8, new BigDecimal(50000)));
        devs.add(new Developer("a", 18, new BigDecimal(30000)));

    }

    @Test
    public void shouldSortListByClassicComparartorByAge() {
        assertEquals("c", subject.sortListByClassicComparatorByAge(devs).get(0).getName());
    }

    @Test
    public void shouldSortListByClassicComparartorByName() {
        assertEquals("a", subject.sortListByClassicComparatorByName(devs).get(0).getName());
    }

    @Test
    public void shouldSortListByClassicComparartorBySalary() {
        assertEquals("b", subject.sortListByClassicComparatorBySalary(devs).get(0).getName());
    }


    @Test
    public void shouldSortListByLambdaByAge(){

        assertEquals("c", subject.sortListByLambdaByAge(devs).get(0).getName());
    }

    @Test
    public void shouldSortListByLambdaByName(){

        assertEquals("a", subject.sortListByLambdaByName(devs).get(0).getName());
    }

    @Test
    public void shouldSortListByLambdaBySalary(){

        assertEquals("b", subject.sortListByLambdaBySalary(devs).get(0).getName());
    }


}
package Application.java8;

import Application.customannotation.TesterInfo;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TesterInfo(
        priority = TesterInfo.Priority.HIGH,
        createdBy = "Sh",
        lastModified = "29/09/2017"
)
public class DoStuffTest {

    private DoStuff subject;
    private List<Developer> devs;
    private List<String> inputList;



    @Before
    public void setUp() throws Exception {
        subject = new DoStuff();
        devs = new ArrayList<>();
        devs.add(new Developer("b", 10, new BigDecimal(20000)));
        devs.add(new Developer("b", 20, new BigDecimal(20000)));
        devs.add(new Developer("c", 35, new BigDecimal(50000)));
        devs.add(new Developer("a", 40, new BigDecimal(30000)));
        devs.add(new Developer("a", 50, new BigDecimal(30000)));
        devs.add(new Developer("a", 60, new BigDecimal(30000)));

        inputList = new ArrayList<>(Arrays.asList(new String[]{"a", "b", "c", "b", "a", "a"}));

    }

    @Test
    public void printStuff() throws Exception {
        subject.printStuff(inputList);
    }

    @Test
    public void sortStuff() throws Exception {

        subject.sortStuff(inputList);
    }

    @Test
    public void groupStuffByName() throws Exception {

        subject.groupStuffByName(devs);
    }

    @Test
    public void groupStuffBySalary() throws Exception {

        subject.groupStuffBySalary(devs);
    }

}
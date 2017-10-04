package Application.java8;

import Application.customannotation.TesterInfo;
import org.junit.Test;

public class TestCustomAnnotation {


    public static void main(String[] args) {
        Class<DoStuffTest> test = DoStuffTest.class;

        if(test.isAnnotationPresent(TesterInfo.class)){
            System.out.println("hi");
            TesterInfo testerInfo = test.getAnnotation(TesterInfo.class);
            System.out.println(testerInfo.createdBy());
            System.out.println(testerInfo.tags().length);
            System.out.println(testerInfo.priority());
            System.out.println(testerInfo.lastModified());
        }else  System.out.println("bye");
    }
}

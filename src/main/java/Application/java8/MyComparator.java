package Application.java8;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*Comparator to sort a list*/
public class MyComparator {

    List<Developer> sortListByLambdaByAge(List<Developer> devs) {

        Comparator<Developer> comp = Comparator.comparingInt(Developer::getAge);
        devs.sort(comp);
        return devs;
    }

    List<Developer> sortListByLambdaByAgeReversed(List<Developer> devs) {

    /*         reversed used ReverseComparator wich calls compare method by passing compare(t2,t1) instead of
    compare(t1,t2) to give reverse sorted result*/
        Comparator<Developer> comp = Comparator.comparingInt(Developer::getAge);
        devs.sort(comp.reversed());

        return devs;
    }

    List<Developer> sortListByLambdaByName(List<Developer> devs) {

        devs.sort(Comparator.comparing(Developer::getName));

        return devs;
    }

    List<Developer> sortListByLambdaBySalary(List<Developer> devs) {

        devs.sort((d1, d2) -> d1.getSalary().subtract(d2.getSalary()).intValue());

        return devs;
    }

    List<Developer> sortListByClassicComparatorByAge(List<Developer> devs) {
        if (validateInputList(devs)) return new ArrayList<>();

        Collections.sort(devs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        return devs;
    }

    List<Developer> sortListByClassicComparatorByName(List<Developer> devs) {
        if (validateInputList(devs)) return new ArrayList<>();

        Collections.sort(devs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return devs;
    }

    List<Developer> sortListByClassicComparatorBySalary(List<Developer> devs) {
        if (validateInputList(devs)) return new ArrayList<>();

        Collections.sort(devs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        });

        return devs;
    }

    private boolean validateInputList(List<Developer> devs) {
        if (null == devs || devs.isEmpty()) {
            return true;
        }
        return false;
    }




}

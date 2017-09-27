package Application.java8;


import java.util.*;

/*Comparator to sort a list*/
public class MyComparator {


   private boolean validateInputList(List<Developer> devs) {
        if(null == devs || devs.isEmpty()){
            return true;
        }
        return false;
    }

    List<Developer> sortListByClassicComparatorByAge(List<Developer> devs) {
        if (validateInputList(devs)) return new ArrayList<>();

        Collections.sort(devs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge()-o2.getAge();
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
                return o1.getSalary().subtract(o2.getSalary()).intValue();
            }
        });

        return devs;
    }

    public List<Developer> sortListByLambdaByAge(List<Developer> devs) {

       devs.sort(Comparator.comparingInt(dev ->dev.getAge()));

       return devs;
    }

    public List<Developer> sortListByLambdaByName(List<Developer> devs) {

        devs.sort(Comparator.comparing(dev -> dev.getName()));

        return devs;
    }

    public List<Developer> sortListByLambdaBySalary(List<Developer> devs) {

        devs.sort((d1, d2) -> d1.getSalary().subtract(d2.getSalary()).intValue());

        return devs;
    }
}

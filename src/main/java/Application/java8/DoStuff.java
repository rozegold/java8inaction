package Application.java8;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DoStuff {


    void printStuff(List<String> devs){
        System.out.println("--print stuff--");
        devs.stream().map(String::toUpperCase).forEach(System.out::print);
        System.out.println();
    }

    void sortStuff(List<String> devs) {


        System.out.println("--sort stuff--");
        Map<String,Long> result = devs.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> finalMap = new LinkedHashMap<>();

        result.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(),e.getValue()) );
        result.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(e -> finalMap.put(e.getKey(),e.getValue()) );


        System.out.println(finalMap);
    }

    void groupStuffByName(List<Developer> devs){

        System.out.println("--group stuff--");
        System.out.println(devs.stream().collect(Collectors.groupingBy(Developer::getName,Collectors.counting())));
        System.out.println(devs.stream().collect(Collectors.groupingBy(Developer::getName,Collectors.summingInt(Developer::getAge))));
    }


    void groupStuffBySalary(List<Developer> devs){
        System.out.println("--group stuff--");
        Map<BigDecimal,List<Developer>> mapofList = devs.stream().collect(Collectors.groupingBy(Developer::getSalary));

        mapofList.forEach((k,v) -> {
            System.out.println(k);
            v.stream().map(Developer::getName).forEach(System.out::println);
        });


       Map<BigDecimal, Set<String>> mapofSet = devs.stream().collect(Collectors.groupingBy(Developer::getSalary,Collectors.mapping(Developer::getName,Collectors.toSet())));

       mapofSet.entrySet().stream().forEach(e -> {
           System.out.println(e.getKey()+": "+e.getValue());
       });


    }
}

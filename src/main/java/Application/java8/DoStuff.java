package Application.java8;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    void groupStuff(List<Developer> devs){

        System.out.println("--group stuff--");
        System.out.println(devs.stream().collect(Collectors.groupingBy(Developer::getName,Collectors.counting())));
        System.out.println(devs.stream().collect(Collectors.groupingBy(Developer::getName,Collectors.summingInt(Developer::getAge))));
    }
}

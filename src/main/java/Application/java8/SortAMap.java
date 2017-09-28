package Application.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortAMap {


    public static void main(String[] args) {
        Map<String, Integer> unsortMap = buildMap();

        unsortMap.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" : "+e.getValue()));


        LinkedHashMap<String,Integer> result = unsortMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(old,newVal)->old,LinkedHashMap::new));




    }

    private static Map<String,Integer> buildMap() {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        return unsortMap;
    }


}

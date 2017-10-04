package Application.java8;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterExamples {


    public static void main(String[] args) {
        FilterExamples f = new FilterExamples();
        f.filterNullElements();

    }

    private void filterNullElements() {

        List<String> list = Stream.of("java",null,"php","rxJava","erlang","mongodb",null,"nodejs",null,"spring")
                .filter(Objects::nonNull).collect(Collectors.toList());

        list.forEach(System.out::println);




    }
}

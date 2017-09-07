package Application;

import Application.FileHandling.FileService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {

    private static final  String fileName = "/Users/shreya/githubworkspace/java8inaction/src/main/resources/textfile.txt";



    public static void main(String[] args) {


        //simpleFileReading();
        List<String> list = bufferedFileReading();

        ;

        //IntStream.rangeClosed(1,5).mapToObj()

    }

    private static List<String> bufferedFileReading() {

        List<String> list = new ArrayList<>();



        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {

            list = reader.lines().filter(s -> s.contains("public")).map(String::toUpperCase).collect(Collectors.toList());
//

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        list.forEach(System.out::println);

        return list;

    }

    private static void simpleFileReading() {
        List<String> list = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {

            list = lines.filter(s -> s.contains("the")).map(String::toUpperCase).collect(Collectors.toList());

        }catch (IOException e){
            e.printStackTrace();

        }

        System.out.print(list.size());
        list.forEach(System.out::println);
    }
}

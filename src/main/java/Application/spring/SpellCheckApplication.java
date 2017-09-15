package Application.spring;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.stream.IntStream;

public class SpellCheckApplication {
    private final Dictionary dictionary;
    public SpellCheckApplication(final Dictionary dictionary) { this.dictionary = dictionary;
    }
    public List<Integer> checkDocument(List<String> document) {

        int documentSize = document.size();

        final List<Integer> misspelledWords = new ArrayList<>();
        IntStream.range(0, documentSize).forEach(i -> {
            if(dictionary.get(document.get(i)) == null ){
                misspelledWords.add(i);
            }
        });


        return misspelledWords;

    }
}

package task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TextAnalyzer textAnalyzer = new TextAnalyzer(new File("words.txt"));
        List<String> list = textAnalyzer.specialWordList(i -> i.length() > 3);
        System.out.println(list);
    }
}

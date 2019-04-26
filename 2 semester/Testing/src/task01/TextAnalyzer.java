package task01;

import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TextAnalyzer {
    private int count = 0;
    private HashMap<String, Integer> hm;
    List<String> uniqueWordList;
    File file;

    public TextAnalyzer(File file) {
        this.file = file;
    }

    public List<String> getUniqueWordFromFile(File file) throws FileNotFoundException {
        hm = new HashMap<>();
        Scanner sc = new Scanner(file);
        String text = "";
        while(sc.hasNext()) {
            text = text + sc.next() + " " ;
        }
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (hm.get(words[i]) == null){
                hm.put(words[i], 1);
            } else {
                count = hm.get(words[i]);
                hm.put(words[i], count + 1);
            }
        }
        /*List<Integer> tmpList = new ArrayList<>(hm.values());
        Collections.sort(tmpList);
        for (int i = 0; i < tmpList.size(); i++) {
            uniqueWordList.add(hm.get())
        }*/
        uniqueWordList = new ArrayList<>(hm.keySet());
        return uniqueWordList;
    }
    public List<String> specialWordList(Predicate<String> predicate) throws FileNotFoundException {
        List<String> wordList = this.getUniqueWordFromFile(file);
        return wordList.stream().filter(predicate).collect(Collectors.toList());
    }
}

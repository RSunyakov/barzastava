import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WordCounter<String, Integer> wc = new WordCounter<>();
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        String[] word = words.split(" ");
        for (int i = 0; i < word.length; i++) {
            wc.putincrease(word[i]);
        }
       WordCounterV2 wc2 = new WordCounterV2();
        System.out.println(wc2.findentry("Привет как дела как как как семь восем девять десять одиннадцать двенадцать как", "как"));
    }
}

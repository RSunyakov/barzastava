public class WordCounterV2 {
    private SimpleMap<String, Integer> sm;
    private int count = 0;

    public Integer findentry(String text, String keyF) {
        sm = new SimpleMap<>();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (sm.get(words[i]) == null){
                sm.put(words[i], 1);
            } else {
                count = sm.get(words[i]);
                sm.put(words[i], count + 1);
            }
        }
        return sm.get(keyF);
    }
}

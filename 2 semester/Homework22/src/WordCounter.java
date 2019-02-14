public class WordCounter<K, V> extends SimpleMap<K, V> {

            public void putincrease(K key) {
            for (int i = 0; i < count; i++) {
                if (entries[i].key.equals(key)) {
                    entries[i].value = (Integer) entries[i].value + 1;
                    return;
                }
            }
            entries[count++] = new Entry(key, 1);
        }
    }

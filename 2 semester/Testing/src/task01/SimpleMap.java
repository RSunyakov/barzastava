package task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class SimpleMap<K, V> implements Map<K, V> {
    protected static final int SIZE = 10;
    protected Entry[] entries;
    private int capacity;
    private static final double EXTENSION_COEF = 1.5;
    protected int count;

    public SimpleMap() {
        this.entries = new Entry[SIZE];
        capacity = SIZE;
        this.count = 0;
    }

    @Override
    public void put(K key, V value) {
        if (capacity == count) {
            int newCapacity = (int) (capacity * EXTENSION_COEF);
            Entry[] newEntries = new Entry[newCapacity];
            for (int i = 0; i < capacity; i++) {
                newEntries[i] = entries[i];
            }
            capacity = newCapacity;
            entries = newEntries;
        }
        for (int i = 0; i < count; i++) {
            if (entries[i].key.equals(key)) {
                entries[i].value = value;
                return;
            }
        }
        entries[count++] = new Entry(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (entries[i].key.equals(key)) {
                return (V) entries[i].value;
            }
        }
        return null;
    }

    class Entry<I, E> {
        I key;
        E value;

        public Entry(I key, E value) {
            this.key = key;
            this.value = value;
        }
    }

}

package hotelbookingsystem.utils;

import java.util.LinkedList;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] array;
    private int size;

    public HashTable(int size) {
        this.size = size;
        array = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            array[i] = new LinkedList<>();
        }
    }

    private int getHash(K key) {
        return key.hashCode() % size;
    }

    public void put(K key, V value) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> list = array[index];
        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        list.addFirst(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> list = array[index];
        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> list = array[index];
        list.removeIf(entry -> entry.key.equals(key));
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

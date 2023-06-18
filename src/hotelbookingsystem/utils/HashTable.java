package hotelbookingsystem.utils;

public class HashTable<K, V> {
    private LinkedList<K, V>[] array;
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
        LinkedList<K, V> list = array[index];
        list.add(key, value);
    }

    public V get(K key) {
        int index = getHash(key);
        LinkedList<K, V> list = array[index];
        return list.get(key);
    }

    public void remove(K key) {
        int index = getHash(key);
        LinkedList<K, V> list = array[index];
        list.remove(key);
    }
}

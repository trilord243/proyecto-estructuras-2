package hotelbookingsystem.utils;


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
        return Math.abs(key.hashCode() % size);
    }

    public void put(K key, V value) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> list = array[index];
        ListNode<Entry<K, V>> node = list.getHead();
        while (node != null) {
            Entry<K, V> entry = node.getData();
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            node = node.getNext();
        }
        list.addFirst(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> list = array[index];
        ListNode<Entry<K, V>> node = list.getHead();
        while (node != null) {
            Entry<K, V> entry = node.getData();
            if (entry.key.equals(key)) {
                return entry.value;
            }
            node = node.getNext();
        }
        return null;
    }

    public void remove(K key) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> list = array[index];
        ListNode<Entry<K, V>> node = list.getHead();
        ListNode<Entry<K, V>> previous = null;
        while (node != null) {
            Entry<K, V> entry = node.getData();
            if (entry.key.equals(key)) {
                if (previous == null) {
                    // estamos eliminando el primer nodo de la lista
                    list.setHead(node.getNext());
                } else {
                    // estamos eliminando un nodo en medio o al final de la lista
                    previous.setNext(node.getNext());
                }
                return;
            }
            previous = node;
            node = node.getNext();
        }
    }

    public int size() {
        int count = 0;
        for (LinkedList<Entry<K, V>> list : array) {
            ListNode<Entry<K, V>> node = list.getHead();
            while (node != null) {
                count++;
                node = node.getNext();
            }
        }
        return count;
    }

    public LinkedList<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for (LinkedList<Entry<K, V>> list : array) {
            ListNode<Entry<K, V>> node = list.getHead();
            while (node != null) {
                keys.append(node.getData().key);
                node = node.getNext();
            }
        }
        return keys;
    }

    public void clear() {
        for (LinkedList<Entry<K, V>> list : array) {
            list.clear();
        }
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


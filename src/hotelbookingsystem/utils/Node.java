package hotelbookingsystem.utils;

public class Node<K extends Comparable<K>, V> {
    K key;
    V value;
    Node<K, V> left, right;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}


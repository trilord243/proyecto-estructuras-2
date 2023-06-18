package hotelbookingsystem.utils;

public class LinkedList<K, V> {
    private Node<K, V> head;

    public LinkedList() {
        this.head = null;
    }

    public void add(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        node.next = head;
        head = node;
    }

    public V get(K key) {
        Node<K, V> node = head;
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(K key) {
        if (head == null) return;
        if (head.key.equals(key)) {
            head = head.next;
            return;
        }

        Node<K, V> node = head;
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }
}

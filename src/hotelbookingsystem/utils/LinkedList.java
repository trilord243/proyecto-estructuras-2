package hotelbookingsystem.utils;

public class LinkedList<K, V> {
    private LinkedListNode<K, V> head;

    public LinkedList() {
        this.head = null;
    }

    public void add(K key, V value) {
        LinkedListNode<K, V> node = new LinkedListNode<>(key, value);
        node.next = head;
        head = node;
    }

    public V get(K key) {
        LinkedListNode<K, V> node = head;
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

        LinkedListNode<K, V> node = head;
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }
}



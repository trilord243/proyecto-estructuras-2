package hotelbookingsystem.utils;

public class BinarySeachTree<V> {
    private class Node {
        Integer key;
        V value;
        Node left, right;

        public Node(Integer key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public void put(Integer key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Integer key, V value) {
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        return x;
    }

    public V get(Integer key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }
}
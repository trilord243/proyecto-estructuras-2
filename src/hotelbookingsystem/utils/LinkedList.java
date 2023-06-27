package hotelbookingsystem.utils;

public class LinkedList<T> {
    private ListNode<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void append(T data) {
        if (head == null) {
            head = new ListNode<>(data);
        } else {
            ListNode<T> node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new ListNode<>(data));
        }
        size++;
    }

    public T get(int index) {
        ListNode<T> node = head;
        for (int i = 0; i < index; i++) {
            if (node == null) {
                return null;
            }
            node = node.getNext();
        }
        if (node != null) {
            return node.getData();
        } else {
            return null;
        }
    }

    public ListNode<T> getHead() {
        return head;
    }

    public void setHead(ListNode<T> head) {
        this.head = head;
    }

    public int size() {
        return size;
    }
    
    public void addFirst(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public boolean contains(T data) {
        ListNode<T> node = head;
        while (node != null) {
            if (node.getData().equals(data)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }
    
    public static String join(LinkedList<String> list, String separator) {
        StringBuilder result = new StringBuilder();
        ListNode<String> node = list.getHead();
        while (node != null) {
            result.append(node.getData());
            if (node.getNext() != null) {
                result.append(separator);
            }
            node = node.getNext();
        }
        return result.toString();
    }
}

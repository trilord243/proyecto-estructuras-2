package hotelbookingsystem.utils;

public class LinkedList<T> {
    private ListNode<T> head;

    public LinkedList() {
        head = null;
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
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.utils;


import hotelbookingsystem.models.Room;

public class BinarySearchTreeRoom {
    private class Node {
        Integer key;
        Room value;
        Node left, right;

        public Node(Integer key, Room value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public void put(Integer key, Room value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Integer key, Room value) {
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        return x;
    }

    public Room get(Integer key) {
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


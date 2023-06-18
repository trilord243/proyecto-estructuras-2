/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.utils;

/**
 *
 * @author Escal
 */
public class LinkedListNode<K, V> {
    K key;
    V value;
    LinkedListNode<K, V> next;

    public LinkedListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
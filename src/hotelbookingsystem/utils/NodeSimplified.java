/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.utils;

/**
 *
 * @author Gabriel Mena
 */
public class NodeSimplified {

    private int data;
    private String name;
    private NodeSimplified left, right;

    public NodeSimplified(int data, String name) {
        this.data = data;
        this.name = name;
        this.left = this.right = null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeSimplified getLeft() {
        return left;
    }

    public void setLeft(NodeSimplified left) {
        this.left = left;
    }

    public NodeSimplified getRight() {
        return right;
    }

    public void setRight(NodeSimplified right) {
        this.right = right;
    }

    public void printData() {
        System.out.println(this.getData());
    }

}

package com.java.practice.linked_list;

public class Node<T> {
    T value;
    Node next;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}

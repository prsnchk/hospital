package com.solvd.hospital.MyLinkedList;

public class Node {
    Node next;
    Object data;

    public Node(Object data) {
        next = null;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object dataValue) {
        data = dataValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        next = nextValue;
    }
}

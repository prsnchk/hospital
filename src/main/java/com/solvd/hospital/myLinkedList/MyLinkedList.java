package com.solvd.hospital.MyLinkedList;

public class MyLinkedList {

        private Node head;
        private int size;

        public MyLinkedList() {
            head = new Node(null);
            size = 0;
        }

        public void add(Object data) {
            Node node = new Node(data);
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
            size++;
        }

        public int getSize() {
            return size;
        }

        public String toString() {
            Node current = head.getNext();
            String elements = "";
            while (current != null) {
                elements += "[" + current.getData().toString() + "]";
                current = current.getNext();
            }
            return elements;
        }
    }
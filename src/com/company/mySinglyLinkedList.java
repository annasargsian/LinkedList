package com.company;

public class mySinglyLinkedList implements List {
    Node first;
    Node last;
    int size;

    @Override
    public void add(Integer number) {
        Node node = new Node(number);
        if (first == null) {
            first = node;
            last = node;
            size++;
            return;
        }
        last.next = node;
        last = node;
        size++;
    }

    @Override
    public boolean remove(Integer number) {
        boolean isRemoved = false;
        Node current = first;
        if (first.value.equals(number)) {
            first = first.next;
            size--;
            isRemoved = true;
        }
        for (int i = 0; i < size - 1; i++) {
            if (current.next.value.equals(number)) {
                current.next = current.next.next;
                size--;
                isRemoved = true;
            }
            current = current.next;
        }
        return isRemoved;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = first;
        for (int i = 0; i < size; i++) {
            result.append(current.value);
            if (i < size - 1) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Integer get(int index) {
        Node current = first;
        Integer item = null;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                item = current.value;
            }
            current = current.next;
        }
        return item;
    }

    @Override
    public void remove(int index) {
        Node current = first;
        if (index == 0) {
            first = first.next;
            size--;
        }
        for (int i = 1; i < size - 1; i++) {
            if (i == index) {
                current.next = current.next.next;
                size--;
            }
            current = current.next;
        }
    }

    @Override
    public int size() {
        Node current = first;
        int counter = 0;
        while (current != last) {
            current = current.next;
            counter++;
        }
        if (first != last) {
            return counter + 1;
        }
        return counter;
    }

    @Override
    public boolean contains(Integer number) {
        Node current = first;
        boolean isContain = false;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(number)) {
                isContain = true;
            }
            current = current.next;
        }
        return isContain;
    }


    class Node {
        Integer value;
        Node next;

        Node(Integer value) {
            this.value = value;
        }
    }

}

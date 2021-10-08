package com.company;

public class myDoubleLinkedList implements List {
    Node first;
    Node last;
    int size;

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
    public void add(Integer number) {
        Node node = new Node(number);
        if (first == null) {
            first = node;
            last = node;
            size++;
            return;
        }
        node.previous = last;
        last.next = node;
        last = node;
        size++;
    }

    @Override
    public void remove(int index) {
        Integer result = get(index);
        remove(result);
    }

    @Override
    public boolean remove(Integer number) {
        Node node = new Node(number);
        if (first.value.equals(number)) {
            first.previous = null;
            first = first.next;
            size--;
            return true;
        }
        Node current = first;
        for (int i = 0; i < size() - 1; i++) {
            if (current.next.value.equals(number)) {
                if (i == size - 2) {
                    current.next = null;
                    last = current;
                } else {
                    current.next.next.previous = current.next.previous;
                    current.next = current.next.next;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
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

    class Node {
        Integer value;
        Node next;
        Node previous;

        Node(Integer value) {
            this.value = value;
        }
    }
}

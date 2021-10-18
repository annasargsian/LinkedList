package com.company;

public class SinglyLinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;


    @Override
    public T get(int index) {
        Node<T> current = first;
        T item = null;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                item = current.value;
            }
            current = current.next;
        }
        return item;
    }

    @Override
    public void add(T item) {
        Node<T> node = new Node<>(item);
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
    public void remove(int index) {
        Node<T> current = first;
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
    public boolean remove(T item) {
        boolean isRemoved = false;
        Node<T> current = first;
        if (first.value.equals(item)) {
            first = first.next;
            size--;
            isRemoved = true;
        }
        for (int i = 0; i < size - 1; i++) {
            if (current.next.value.equals(item)) {
                current.next = current.next.next;
                size--;
                isRemoved = true;
            }
            current = current.next;
        }
        return isRemoved;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T item) {
        Node current = first;
        boolean isContain = false;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(item)) {
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

    @Override
    public Iterator<T> iterator() {
        return new Helper();
    }
    private class  Helper implements Iterator<T>{
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
    class Node<T> {
        private T value;
        private Node<T> next;
        
        Node(T value) {
            this.value = value;
        }
    }


}

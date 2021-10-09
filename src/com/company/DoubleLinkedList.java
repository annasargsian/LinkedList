package com.company;

public class DoubleLinkedList<T> implements List<T> {
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
        Node node = new Node(item);
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
        T result = get(index);
        remove(result);
    }

    @Override
    public boolean remove(T item) {
        Node<T> node = new Node(item);
        if (first.value.equals(item)) {
            first.previous = null;
            first = first.next;
            size--;
            return true;
        }
        Node<T> current = first;
        for (int i = 0; i < size() - 1; i++) {
            if (current.next.value.equals(item)) {
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
        return size;
    }

    @Override
    public boolean contains(T item) {
        Node<T> current = first;
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

    class Node<T> {
        private T value;
        Node<T> next;
        Node<T> previous;

        Node(T value) {
            this.value = value;
        }
    }
}

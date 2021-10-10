package com.company;

public class DoubleLinkedList<T> implements List<T>, Queue<T> {
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
    public void addFirst(T item) {
        Node node = new Node(item);
        if (first == null) {
            first = node;
            last = node;
            size++;
            return;
        }
        first.previous = node;
        node.next = first;
        first = node;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node node = new Node(item);
        if (last == null) {
            first = node;
            last = node;
            size++;
            return;
        }
        last.next = node;
        node.previous = last;
        last = node;
        size++;
    }

    @Override
    public void removeFirst() {
        first = first.next;
        first.previous = null;
        size--;
    }

    @Override
    public void removeLast() {
        last = last.previous;
        last.next = null;
        size--;
    }

    @Override
    public void push(T item) {
        addFirst(item);
    }

    @Override
    public void pop(T item) {
        if (first.value.equals(item)) {
            removeFirst();
        }
    }

    @Override
    public boolean offerFirst(T item) {
        int count = size;
        addFirst(item);
        if (count + 1 == size) {
            return true;
        }
        return false;
    }

    @Override
    public boolean offerLast(T item) {
        int count = size;
        if(last.value.equals(item)) {
            removeLast();
            if (count - 1 == size) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T poll() {
        if (first == null) {
            return null;
        }
        T tmp = (T) first;
        removeFirst();
        return tmp;
    }

    @Override
    public T pollFirst() {
        return poll();
    }

    @Override
    public T pollLast() {
        if (first == null) {
            return null;
        }
        T tmp = (T) last;
        removeLast();
        return tmp;
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

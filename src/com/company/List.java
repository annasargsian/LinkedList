package com.company;

public interface List<T> {

    T get(int index);

    void add(T item);

    void remove(int index);

    boolean remove(T item);

    int size();

    boolean contains(T item);

    ListIterator<T> iterator();

    Iterator<T> descendingIterator();

    interface ListIterator<T> {
        boolean hasNext();

        T next();

        boolean hasPrevious();

        T previous();
    }

    interface Iterator<T> {
        boolean hasNext();

        T next();
    }
}

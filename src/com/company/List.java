package com.company;

public interface List<T> {

    T get(int index);

    void add(T item);

    void remove(int index);

    boolean remove(T item);

    int size();

    boolean contains(T item);
}

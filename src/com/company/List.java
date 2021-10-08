package com.company;

public interface List {

    Integer get(int index);

    void add(Integer number);

    void remove(int index);

    boolean remove(Integer number);

    int size();

    boolean contains(Integer number);
}

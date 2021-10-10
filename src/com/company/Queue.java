package com.company;

public interface Queue<T> {
   void addFirst(T item);

   void addLast(T item);

    void add(T element);

    void removeFirst();

    void removeLast();

    void push(T item);

    void pop(T item);

   boolean offerFirst(T item);

   boolean offerLast(T item);

//    descendingIterator();

    T poll();

    T pollFirst();

    T pollLast();

//    iterator();
}

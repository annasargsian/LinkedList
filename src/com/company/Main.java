package com.company;

public class Main {

    public static void main(String[] args) {
        mySinglyLinkedList linkedList = new mySinglyLinkedList();
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());
        System.out.println(linkedList.contains(7));
        System.out.println(linkedList.contains(3));
        linkedList.remove(1);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.remove((Integer) 5));

        myDoubleLinkedList doubleLinkedList = new myDoubleLinkedList();
        doubleLinkedList.add(4);
        doubleLinkedList.add(5);
        doubleLinkedList.add(6);
        System.out.println(doubleLinkedList.toString());
        System.out.println(doubleLinkedList.get(2));
        doubleLinkedList.remove(((Integer) 6));
        doubleLinkedList.remove(1);
        System.out.println(doubleLinkedList.toString());

    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
//        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
//        linkedList.add(5);
//        linkedList.add(6);
//        linkedList.add(7);
//        System.out.println(linkedList.toString());
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.contains(7));
//        System.out.println(linkedList.contains(3));
//        linkedList.remove(1);
//        System.out.println(linkedList.toString());
//        System.out.println(linkedList.get(0));
//        System.out.println(linkedList.remove((Integer) 5));

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(4);
        doubleLinkedList.add(5);
        doubleLinkedList.add(6);
//        System.out.println(doubleLinkedList.toString());
//        System.out.println(doubleLinkedList.get(2));
//        doubleLinkedList.remove(((Integer) 6));
//        doubleLinkedList.remove(1);
        System.out.println(doubleLinkedList.toString());
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addLast(8);
        System.out.println(doubleLinkedList.toString());
        doubleLinkedList.removeFirst();
        doubleLinkedList.removeLast();
        doubleLinkedList.pop(4);
        System.out.println(doubleLinkedList.offerFirst(7));
        System.out.println(doubleLinkedList.offerLast(0));
        doubleLinkedList.poll();
        doubleLinkedList.pollLast();
        doubleLinkedList.push(9);
        System.out.println(doubleLinkedList.toString());


    }
}

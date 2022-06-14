package main;

import memento.LinkedList;
import memento.Memento;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LinkedList myList = new LinkedList(3);
        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);

        Memento memento = myList.createMemento();

        myList.addLast(4);
        myList.addLast(5);
        myList.addLast(6);

        System.out.println("Before: ");

        for (int i = 0; i < myList.getSize(); i++) {
            System.out.println(myList.getElementValue(i));
        }

        myList.setMemento(memento);

        System.out.println("After: ");

        for (int i = 0; i < myList.getSize(); i++) {
            System.out.println(myList.getElementValue(i));
        }
    }
}

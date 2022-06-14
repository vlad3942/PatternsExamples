package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList {

    private int size = 0;

    private final Node head = new Node();

    public LinkedList(int initSize) {
        for (int i = 0; i < initSize; i++) {
            addLast(0.0);
        }
    }

    public void addLast(double value) {
        final Node addedNode = new Node(value, head, head.prev);
        head.prev.next = addedNode;
        head.prev = addedNode;
        size++;
    }

    public double getElementValue(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int tmp = 0;
        Node current = head.next;
        while (tmp != index) {
            current = current.next;
            tmp++;
        }
        return current.value;
    }

    public Node getHead() {
        return this.head;
    }

    public int getSize() {
        return this.size;
    }

    public Iterator<Double> getIterator() {
        return new LinkedListIterator(this);
    }

    public static void main(String[] args) {
        final LinkedList list = new LinkedList(2);
        list.addLast(7);
        list.addLast(6);
        list.addLast(5);
        Iterator<Double> iter = list.getIterator();
        int i = 0;
        while (iter.hasNext()) {
            System.out.println(i++ + " - " + iter.next());
        }
    }

    public static class LinkedListIterator implements Iterator<Double> {

        private final LinkedList list;
        private int index = 0;

        LinkedListIterator(final LinkedList list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return index < list.getSize();
        }

        @Override
        public Double next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return list.getElementValue(index++);
        }
    }

    public static class Node {
        private double value;
        private Node next;
        private Node prev;

        public Node() {
            this.next = this;
            this.prev = this;
        }

        public Node(double value) {
            this();
            this.value = value;
        }

        public Node(double value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}

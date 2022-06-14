package memento;

import java.io.*;

public class LinkedList {

    private int size = 0;

    private Node head = new Node();

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

    public Memento createMemento() throws IOException {
        return new MementoList(this);
    }

    public void setMemento(Memento memento) throws IOException, ClassNotFoundException {
        if (!(memento instanceof MementoList)) {
            throw new IllegalArgumentException();
        }
        ((MementoList) memento).mementoState(this);
    }

    public static class MementoList implements Memento {

        private final byte[] state;

        private final int size;

        MementoList(final LinkedList list) throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            this.size = list.size;
            new ObjectOutputStream(baos).writeObject(list.head);
            state = baos.toByteArray();
        }

        private void mementoState(final LinkedList list) throws IOException, ClassNotFoundException {
            list.size = this.size;
            list.head = (Node) new ObjectInputStream(new ByteArrayInputStream(this.state)).readObject();
        }
    }

    public static class Node implements Serializable {
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

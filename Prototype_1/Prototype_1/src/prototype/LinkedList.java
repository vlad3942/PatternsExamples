package prototype;

public class LinkedList implements Cloneable {

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


    @Override
    public LinkedList clone() {
        final LinkedList list;
        try {
            list = (LinkedList) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
        list.size = this.size;
        list.head = this.head.clone();
        Node temp = this.head.next;
        for (int i = 0; i < this.size; i++) {
            Node tmp = temp.clone();
            tmp.prev = list.head.prev;
            tmp.next = list.head;
            list.head.prev.next = tmp;
            list.head.prev = tmp;
            temp = temp.next;
        }
        return list;
    }

    public static class Node implements Cloneable {
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

        public Node getNext() {
            return next;
        }

        public Node clone() {
            try {
                final Node newNode = (Node) super.clone();
                newNode.next = newNode;
                newNode.prev = newNode;
                newNode.value = this.value;
                return newNode;
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}

import prototype.LinkedList;

public class Main {
    public static void main(String[] args) {
        final LinkedList myList = new LinkedList(2);
        myList.addLast(150);
        myList.addLast(160);
        myList.addLast(170);

        final LinkedList myListClone = myList.clone();

        //check links:
        if (myList == myListClone) {
            System.err.println("Problem with clone.");
        } else {
            System.out.println("Clone is ok.");
        }

        LinkedList.Node head1 = myList.getHead();
        LinkedList.Node head2 = myListClone.getHead();

        if (head1 == head2) {
            System.err.println("Error: heads are equals");
        } else {
            System.out.println("Heads are ok.");
        }

        LinkedList.Node first1 = head1.getNext();
        LinkedList.Node first2 = head2.getNext();

        for (int i = 0; i < myList.getSize(); i++) {
            //check values:
            if (myList.getElementValue(i) == myListClone.getElementValue(i)) {
                System.out.println("Ok value - " + i);
            } else {
                System.err.println(myList.getElementValue(i) + " != " + myListClone.getElementValue(i));
            }
            //check node links
            if (first1 == first2) {
                System.err.println("Error: Links of elements are equals");
            } else {
                System.out.println("Ok Node link - " + i);
            }
        }

    }
}

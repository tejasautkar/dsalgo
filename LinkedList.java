/**
 * LinkedList
 */
public class LinkedList {
    private Node head; // Head of the LinkedList

    /**
     * Node - Creates a node
     */
    public static class Node {
        Node next;
        int data;

        Node(int nodeData) {
            data = nodeData;
            next = null;
        }

    }

    /*
     * Inserts a node to the linkedList and returns the list
     */

    public static LinkedList insert(LinkedList list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }

        return list;

    }

    public static LinkedList insertAtPosition(LinkedList list, int index, int data) {
        Node curr = list.head, prev = null, n = new Node(data);

        if (index == 0 && curr != null) {
            n.next = list.head;
            list.head = n;
            System.out.println("Added at head");
            return list;
        }

        int counter = 0;

        while (curr != null) {
            if (counter == index) {
                prev.next = n;
                n.next = curr;
                System.out.println("Added " + data + "At " + index);
                break;
            } else {
                prev = curr;
                curr = curr.next;
                counter++;
            }
        }

        if (curr == null && counter == index) {
            System.out.println("counter " + counter);
            prev.next = n;
            n.next = null;
            System.out.println("Added to the last");
            return list;
        } else if (curr == null && counter < index) {
            System.out.println("Out of bound");
        }
        return list;
    }

    /**
     * Print the linkedList
     */

    public static void printList(LinkedList list) {
        System.out.println("Head of list is " + list.head.data);
        Node currentNode = list.head;
        if (list.head == null) {
            System.out.println("Error- list is Empty");
        } else {
            while (currentNode != null) {
                System.out.println(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }
    }

    /**
     * 
     * Deletes a node by key
     * 
     * @param list : LinkedList that needs to be searched
     * @param key  : key that needs to be searched and delete
     */

    public static LinkedList deleteByKey(LinkedList list, int key) {
        Node currentNode = list.head, prev = null; // To traverse always start with head and initialise prev to null

        // As currentNode is head. So, if the key is data of head,change the head to the
        // node to the next of the head
        if (currentNode != null && currentNode.data == key) {
            list.head = currentNode.next;
            System.out.println("Key " + key + " found and deleted");
            return list;
        }

        // If not at head traverse throught the list. If key is not found make prev the
        // currentNode and currentNode the next Node
        while (currentNode != null && currentNode.data != key) {
            prev = currentNode;
            currentNode = currentNode.next;
        }

        /// if key is found at B
        // A. d1 B , B. d2 C, C. d3 D -> change this to A. d1 C, C. d3 D (deleted B)

        if (currentNode != null) {
            prev.next = currentNode.next; // In eg in the comment above prev will be A and currentNode will be B
            System.out.println("Key " + key + " found and deleted");
            return list;
        }

        // If key not found currentNode will be null
        if (currentNode == null) {
            System.out.println("key " + key + " not found");
        }
        return list;
    }

    public static LinkedList deleteAtPosition(LinkedList list, int index) {
        System.out.println("LinkedList.deleteAtPosition()");
        Node curr = list.head, prev = null;
        if (curr != null && index == 0) {
            list.head = curr.next;
            System.out.println("Deleted key at head");
            return list;
        }
        int counter = 0;

        while (curr != null) {
            if (counter == index) {
                prev.next = curr.next;
                System.out.println(index + " position element deleted");
                break;
            } else {
                prev = curr;
                curr = curr.next;
                counter++;
            }
        }

        if (curr == null) {
            System.out.println(index + " position element not found");
        }

        return list;
    }

    /*
     * Reverses a Linked list
     */
    public static LinkedList reverse(LinkedList list) {
        Node current = list.head, prev = null, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list.head = prev;
        return list;
    }

    public static int printNodeData(Node n) {
        if (n != null) {
            return n.data;
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList l2 = new LinkedList();
        //
        // ******INSERTION******
        //

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // add to l2
        l2 = insert(l2, 1);
        l2 = insert(l2, 2);
        l2 = insert(l2, 3);
        l2 = insert(l2, 4);
        l2 = insert(l2, 5);
        l2 = insert(l2, 6);
        l2 = insert(l2, 7);
        l2 = insert(l2, 8);

        printList(l2);
        reverse(l2);
        System.out.println("reversing!!!!!!");
        printList(l2);

        // insert at head

        // insertAtPosition(l2, 8, 9);
        // insertAtPosition(l2, 10, 10);
        // insertAtPosition(l2, 9, 11);
        // insertAtPosition(l2, 10, 12);
        // insertAtPosition(l2, 11, 13);

        // printList(l2);

        // Print the LinkedList
        // printList(list);

        // //
        // // ******DELETION BY KEY******
        // //

        // // Delete node with value 1
        // // In this case the key is ***at head***
        // deleteByKey(list, 1);

        // // Print the LinkedList
        // printList(list);

        // // Delete node with value 4
        // // In this case the key is present ***in the
        // // middle***
        // deleteByKey(list, 4);

        // // Print the LinkedList
        // printList(list);

        // // Delete node with value 10
        // // In this case the key is ***not present***
        // deleteByKey(list, 10);

        // // Last
        // deleteByKey(list, 8);

        // // Print the LinkedList
        // printList(list);

        //
        // ******DELETION AT POSITION******
        //

        // Delete node at position 0
        // In this case the key is ***at head***
        // deleteAtPosition(list, 0);

        // Print the LinkedList
        // printList(list);

        // Delete node at position 2
        // In this case the key is present ***in the
        // middle***
        // deleteAtPosition(list, 4);

        // Print the LinkedList
        // printList(list);

        // Delete node at position 10
        // In this case the key is ***not present***
        // deleteAtPosition(list, 10);

        // Print the LinkedList
        // printList(list);
    }
}
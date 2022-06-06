public class LinkedListQuestions extends LinkedList {

    LinkedListQuestions() {
        super();
    }

    // Given a singly linked list, find the middle of the linked list. For example,
    // if the given linked list is 1->2->3->4->5 then the output should be 3.
    // If there are even nodes, then there would be two middle nodes, we need to
    // print the second middle element. For example, if given linked list is
    // 1->2->3->4->5->6 then the output should be 4.

    public void printMiddle() {
        Node slowptr = head;
        Node fastptr = head;

        while (fastptr != null && fastptr.next != null) {
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
        }
        System.out.println("Middle element is [ " + slowptr.data + "]");

    }

    public void deleteMiddle() {
        Node slowptr = head;
        Node fastptr = head;
        Node prev = null;

        while (fastptr != null && fastptr.next != null) {
            fastptr = fastptr.next.next;
            prev = slowptr;
            slowptr = slowptr.next;
        }
        prev.next = slowptr.next;
        System.out.println("Deleted element is [" + slowptr.data + "]");

    }

    Node deleteMid(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slowptr = head;
        Node fastptr = head;
        Node prev = null;

        while (fastptr != null && fastptr.next != null) {
            fastptr = fastptr.next.next;
            prev = slowptr;
            slowptr = slowptr.next;
        }
        prev.next = slowptr.next;
        return slowptr;
    }

    void removeDuplicateElements() {
        Node curr = this.head, prev = null;
        while (curr != null) {
            if (prev != null && prev.data == curr.data) {
                prev.next = curr.next;
            } else {
                prev = curr; // I messed up here earlier as I didn't put else. Else is required here because
                             // if a node is deleted then you need not assign it to prev as it won't delete
                             // in the case of last elements being duplicate
            }
            curr = curr.next;
        }
    }

    // Nth node from end of linked list
    // Given a linked list consisting of L nodes and given a number N. The task is
    // to find the Nth node from the end of the linked list.

    int getNthFromLast(LinkedList list, int n) {
        Node mainPtr = list.head, refPtr = list.head;
        int counter = 0;
        while (counter < n) {
            if (refPtr == null) {
                return -1;
            }
            refPtr = refPtr.next;
            counter++;
        }
        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        return mainPtr.data;
    }

    // Function to check if a singly linked list is a palindrome
    // ToDo
    // multiple traversal
    boolean isPalindrome(Node head) {
        Node first = head, second = head;
        int size = 0;
        while (first != null) {
            size++;
            first = first.next;
        }

        return true;
    }

    public static void main(String[] args) {
        try {
            LinkedListQuestions l1 = new LinkedListQuestions();
            insert(l1, 1);
            insert(l1, 2);
            insert(l1, 3);
            insert(l1, 4);
            insert(l1, 5);
            insert(l1, 6);
            insert(l1, 6);
            insert(l1, 6);
            // printList(l1);
            l1.removeDuplicateElements();
            printList(l1);

        } catch (Exception e) {
            System.out.println(e);
        }
        ;
    }
}
import java.util.Stack;

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
    // Stack Approach. Add to stack and traverse again compare with check stack.pop
    // now
    boolean isPalindrome(Node head) {
        Node first = head, second = head;
        Stack<Integer> st = new Stack<Integer>();
        while (first != null) {
            st.push(first.data);
            first = first.next;
        }
        while (second != null) {
            if (second.data != st.pop()) {
                return false;
            }
            second = second.next;
        }
        return true;
    }

    // Delete last occurrence of an item from linked list
    // First approach that came to mind
    static LinkedList delLastOccurence(LinkedList list, int item) {
        Node ptr = list.head, mainPrev = null, curr = null, prev = null;
        while (ptr != null) {
            if (ptr.data == item) {
                prev = mainPrev;
                curr = ptr.next;
            }
            mainPrev = ptr;
            ptr = ptr.next;
        }
        if (prev == null && curr == null) {
            return list;
        }
        if (prev == null && curr != null) {
            System.out.println("there");
            Node temp = list.head;
            list.head = list.head.next;
            temp = null;
            return list;
        }
        if (prev != null && curr != null) {
            prev.next = curr.next;
            return list;
        }
        if (prev != null && curr == null) {
            System.out.println("here");
            prev.next = curr;
            return list;
        }
        return list;
    }

    void deleteList() {
        this.head = null;
    }

    // Add 1 to a number represented as linked list
    LinkedList addToList(LinkedList list) {
        list = reverseList(list);
        Node curr = list.head;
        int carry = 1, sum = 0;
        while (curr != null) {
            sum = curr.data + carry;
            System.out.println("sum " + sum);
            carry = (sum >= 10) ? 1 : 0;
            System.out.println("carry " + carry);
            sum = sum % 10;
            curr.data = sum;
            curr = curr.next;
        }
        if (carry > 0) {
            insert(list, carry);
        }
        return reverse(list);

    }

    LinkedList reverseList(LinkedList list) {
        Node curr = list.head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;
        return list;
    }

    public static void main(String[] args) {
        try {
            LinkedListQuestions l1 = new LinkedListQuestions();
            insert(l1, 9);
            insert(l1, 9);
            insert(l1, 9);
            insert(l1, 9);
            insert(l1, 9);
            insert(l1, 9);
            insert(l1, 9);
            insert(l1, 9);
            // printList(l1);
            // l1.removeDuplicateElements();
            // System.out.println("Is list palindrome? Ans - " + l1.isPalindrome(l1.head));
            // printList(l1);
            // delLastOccurence(l1, 11);
            l1.addToList(l1);
            printList(l1);

        } catch (Exception e) {
            System.out.println(e);
        }
        ;
    }
}
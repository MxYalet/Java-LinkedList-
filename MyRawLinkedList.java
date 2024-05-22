/*
 * I attest that the code in this file is entirely my own except for the starter
 * code provided with the assignment and the following exceptions:
 * <Enter all external resources and collaborations here. Note external code may
 * reduce your score but appropriate citation is required to avoid academic
 * integrity violations. Please see the Course Syllabus as well as the
 * university code of academic integrity:
 *  https://catalog.upenn.edu/pennbook/code-of-academic-integrity/ >
 * Signed,
 * Author: YOUR NAME HERE
 * Penn email: <YOUR-EMAIL-HERE@seas.upenn.edu>
 * Date: YYYY-MM-DD
 */

import java.util.*;

public class MyRawLinkedList {
    private static final long serialVersionUID = 1561306366555780559L;

    static class Node {
        private static final long serialVersionUID = -3505677833599614054L;
        String value;
        Node next = null;

        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(String value) {
            this(value, null);
        }
    }

    /* This is intentionally left private so that you can't erroneously try to
     * instantiate a `new MyRawLinkedList()`
     */
    private MyRawLinkedList() {}

    /*
     * These methods included as examples for how to use Node as a linked list.
     */
    public static String listToString(Node head) {
        String ret = "";
        while (head != null) {
            ret += "\"" + head.value + (head.next == null ? "\" " : "\", ");
            head = head.next;
        }
        return "[ " + ret + "]";
    }

    public static void print(Node head) {
        System.out.println(listToString(head));
    }

    /*
     * Do not call this method in your code; it is not efficient. It is just for our
     * test cases.
     */
    public static String get(Node head, int index) {
        if (index < 0 || index >= size(head)) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }
    }

    /* Do not call this method in your code. It is just for the test cases. */
    public static boolean contains(Node head, String value) {
        Node current = head;
        while (current != null) {
            if (current.value == value || current.value != null && current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /* Do not call this method in your code. It is just for the test cases. */
    public static int size(Node head) {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public static void main(String[] args) {
        Node list1 = new Node("One", new Node("Two", new Node("Three", null)));
        print(list1);

        Node args_as_list = null;
        for (int i = args.length - 1; i >= 0; i--)
            args_as_list = new Node(args[i], args_as_list);

        print(args_as_list);

        Node list2 = null;
        list2 = new Node("a", list2);
        list2 = new Node("b", list2);
        list2 = new Node("c", list2);
        print(list2);
    }

    /*
     * Implement the methods below. Please do not change their signatures!
     */

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            // Store the next node
            next = current.next;

            // Reverse the link
            current.next = prev;

            // Move prev and current one step forward
            prev = current;
            current = next;
        }

        // prev will be the new head of the reversed list
        return prev;
    }


    public static Node removeMaximumValues(Node head, int N) {
        // Handle cases for empty list or non-positive N
        if (head == null || N <= 0) return head;

        // Traverse the list to collect values
        List<String> values = new ArrayList<>();
        Node current = head;
        while (current != null) {
            values.add(current.value);
            current = current.next;
        }

        // Sort the values and find the N largest unique values
        Collections.sort(values);
        Set<String> largestValues = new HashSet<>();
        for (int i = values.size() - 1; i >= 0 && largestValues.size() < N; i--) {
            largestValues.add(values.get(i));
        }

        //Remove nodes containing the N largest values
        Node dummy = new Node(null, head);
        Node prev = dummy;
        current = head;
        while (current != null) {
            if (largestValues.contains(current.value)) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }

        // Return the new head of the list
        return dummy.next;
    }


    public static boolean containsSubsequence(Node head, Node other) {
        // An empty sequence is a valid subsequence of any sequence
        if (other == null) return true;
        // A non-empty sequence cannot be a subsequence of an empty sequence
        if (head == null) return false;

        Node current1 = head;

        while (current1 != null) {
            Node temp1 = current1;
            Node temp2 = other;

            while (temp1 != null && temp2 != null) {
                if ((temp1.value == null && temp2.value == null) ||
                        (temp1.value != null && temp1.value.equals(temp2.value))) {
                    temp2 = temp2.next;
                }
                temp1 = temp1.next;
            }

            // Reached the end of the 'other' list, hence it is a subsequence
            if (temp2 == null) return true;
            current1 = current1.next;
        }

        // No matching subsequence found
        return false;
    }


}

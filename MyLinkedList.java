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

import java.util.HashMap;
import java.util.Map;

public class MyLinkedList {

    private static final long serialVersionUID = 1663679278942178557L;
    static class Node {
        private static final long serialVersionUID = -539394075146871892L;
        String value;
        Node next;

        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(String value) {
            this(value, null);
        }
    }

    protected Node head = null;
    protected Node tail = null;
    protected int size = 0;

    public void addFirst(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(String value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void add(int index, String value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node newNode = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            if (current.next == null) {
                tail = newNode;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }
    }

    public boolean contains(String value) {
        Node current = head;
        while (current != null) {
            if (current.value == value || current.value != null && current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        } else {
            return;
        }
        if (head == null) {
            tail = null;
        }
        if (size > 0)
            size--;
    }

    public void removeLast() {
        if (head == null) { // empty list
            return;
        } else if (head == tail) {
            // single element list
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            current.next = null;
        }
        size--;
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        else if (index == 0)
            removeFirst();
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
            size--;
        }
    }

    /*
     * Implement the methods below. Please do not change their signatures!
     */

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        // Updates tail to point to the previous head
        tail = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }


    public void removeMaximumValues(int N) {
        if (N <= 0 || head == null) {
            return; // Nothing to remove if N is non-positive or list is empty
        }

        // Count the occurrences of each value
        Map<String, Integer> valueCounts = new HashMap<>();
        Node current = head;
        while (current != null) {
            valueCounts.put(current.value, valueCounts.getOrDefault(current.value, 0) + 1);
            current = current.next;
        }

        int removedCount = 0;
        while (removedCount < N) {
            if (valueCounts.isEmpty()) {
                break; // No more values to remove
            }

            // Find the maximum value and its count
            String max = null;
            int maxCount = 0;
            for (Map.Entry<String, Integer> entry : valueCounts.entrySet()) {
                if (max == null || entry.getValue() > maxCount) {
                    max = entry.getKey();
                    maxCount = entry.getValue();
                }
            }
            // Remove all occurrences of the maximum value
            current = head;
            Node prev = null;
            while (current != null) {
                if (current.value.equals(max)) {
                    if (prev == null) {
                        head = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    if (current.next == null) {
                        tail = prev;
                    }
                    size--;
                    removedCount++;
                } else {
                    prev = current;
                }
                current = current.next;
            }
            // Remove the maximum value from the map
            valueCounts.remove(max);
        }
    }

    public Boolean containsSubsequence(MyLinkedList other) {
        if (other == null || other.head == null) {
            // Return null when the other list is null or empty
            return null;
        }

        if (head == null) {
            // Return false if the current list is empty
            return false;
        }

        Node current = head;
        Node otherCurrent = other.head;

        while (current != null) {
            if (current.value.equals(otherCurrent.value)) {
                Node tempCurrent = current;
                Node tempOtherCurrent = otherCurrent;
                while (tempCurrent != null && tempOtherCurrent != null && tempCurrent.value.equals(tempOtherCurrent.value)) {
                    tempCurrent = tempCurrent.next;
                    tempOtherCurrent = tempOtherCurrent.next;
                }
                if (tempOtherCurrent == null) {
                    // Found a matching subsequence
                    return true;
                }
            }
            current = current.next;
        }

        // No matching subsequence found
        return false;
    }


}

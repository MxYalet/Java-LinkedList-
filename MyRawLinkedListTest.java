/*
 ***** Important!  Please Read! *****
 *
 *  - Do NOT remove any of the existing import statements
 *  - Do NOT import additional junit packages 
 *  - You MAY add in other non-junit packages as needed
 * 
 *  - Do NOT remove any of the existing test methods or change their name
 *  - You MAY add additional test methods.  If you do, they should all pass
 * 
 *  - ALL of your assert test cases within each test method MUST pass, otherwise the 
 *        autograder will fail that test method
 *  - You MUST write the require number of assert test cases in each test method, 
 *        otherwise the autograder will fail that test method
 *  - You MAY write more than the required number of assert test cases as long as they all pass
 * 
 *  - All of your assert test cases within a method must be related to the method they are meant to test
 *  - All of your assert test cases within a method must be distinct and non-trivial
 *  - Your test cases should reflect the method requirements in the homework instruction specification
 * 
 *  - Your assert test cases will be reviewed by the course instructors and they may take off
 *        points if your assert test cases to do not meet the requirements
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;

class MyRawLinkedListTest {
	
	@Test
	void testRawContainsSubsequence() {
		// TODO
		/* 
		 * Write at least 5 assert test case that test your 'containsSubsequence' method
		 * Review the homework instructions and write assert test realated the this methods specification
		 * All 5 assert statements MUST pass.
		 */

		// Test Case 1: Subsequence in the middle of the list
		MyRawLinkedList.Node list1 = new MyRawLinkedList.Node("A", new MyRawLinkedList.Node("B", new MyRawLinkedList.Node("C", new MyRawLinkedList.Node("D", null))));
		MyRawLinkedList.Node subsequence1 = new MyRawLinkedList.Node("B", new MyRawLinkedList.Node("C", null));
		assertTrue(MyRawLinkedList.containsSubsequence(list1, subsequence1));

		// Test Case 2: Subsequence at the start and end of the list
		MyRawLinkedList.Node subsequence2 = new MyRawLinkedList.Node("A", new MyRawLinkedList.Node("D", null));
		assertTrue(MyRawLinkedList.containsSubsequence(list1, subsequence2));

		// Test Case 3: Non-existent subsequence
		MyRawLinkedList.Node subsequence3 = new MyRawLinkedList.Node("C", new MyRawLinkedList.Node("E", null));
		assertFalse(MyRawLinkedList.containsSubsequence(list1, subsequence3));

		// Test Case 4: Empty subsequence should return true
		MyRawLinkedList.Node emptySubsequence = null;
		assertTrue(MyRawLinkedList.containsSubsequence(list1, emptySubsequence));

		// Test Case 5: Subsequence longer than the list
		MyRawLinkedList.Node subsequenceLonger = new MyRawLinkedList.Node("A", new MyRawLinkedList.Node("B", new MyRawLinkedList.Node("C", new MyRawLinkedList.Node("D", new MyRawLinkedList.Node("E", null)))));;
		assertFalse(MyRawLinkedList.containsSubsequence(list1, subsequenceLonger));


	}

	@Test
	void testRawRemoveMaximumValues() {
		// TODO
		/* 
		 * Write at least 5 assert test case that test your 'removeMaximumValues' method
		 * Review the homework instructions and write assert test realated the this methods specification
		 * All 5 assert statements MUST pass.
		 */
		// Test Case 1: Remove the largest value once
		MyRawLinkedList.Node list1 = new MyRawLinkedList.Node("DOG", new MyRawLinkedList.Node("GORILLA", new MyRawLinkedList.Node("BANANA", new MyRawLinkedList.Node("CAT", new MyRawLinkedList.Node("GORILLA", new MyRawLinkedList.Node("BEAR", null))))));
		MyRawLinkedList.Node modifiedList1 = MyRawLinkedList.removeMaximumValues(list1, 1);
		assertFalse(MyRawLinkedList.contains(modifiedList1, "GORILLA"));

		// Test Case 2: Remove the largest value twice
		MyRawLinkedList.Node list2 = new MyRawLinkedList.Node("KANGAROO", new MyRawLinkedList.Node("PLATYPUS", new MyRawLinkedList.Node("AARDVARK", new MyRawLinkedList.Node("KANGAROO", new MyRawLinkedList.Node("DONKEY", new MyRawLinkedList.Node("COYOTE", null))))));
		MyRawLinkedList.Node modifiedList2 = MyRawLinkedList.removeMaximumValues(list2, 2);
		assertFalse(MyRawLinkedList.contains(modifiedList2, "PLATYPUS"));
		assertFalse(MyRawLinkedList.contains(modifiedList2, "KANGAROO"));

		// Test Case 3: Remove all values
		MyRawLinkedList.Node list3 = new MyRawLinkedList.Node("A", new MyRawLinkedList.Node("B", new MyRawLinkedList.Node("A", null)));
		MyRawLinkedList.Node modifiedList3 = MyRawLinkedList.removeMaximumValues(list3, 2);
		assertNull(modifiedList3);

		// Test Case 5: Remove maximum values from an empty list
		MyRawLinkedList.Node list5 = null;
		MyRawLinkedList.Node modifiedList5 = MyRawLinkedList.removeMaximumValues(list5, 1);
		assertNull(modifiedList5);

	}

	@Test
	void testRawReverse() {
		// TODO
		/* 
		 * Write at least 5 assert test case that test your 'reverse' method
		 * Review the homework instructions and write assert test realated the this methods specification
		 * All 5 assert statements MUST pass.
		 */
		// Test Case 1: Reverse a non-empty list
		MyRawLinkedList.Node list1 = new MyRawLinkedList.Node("A", new MyRawLinkedList.Node("B", new MyRawLinkedList.Node("C", null)));
		MyRawLinkedList.Node reversedList1 = MyRawLinkedList.reverse(list1);
		assertEquals("C", reversedList1.value);
		assertEquals("B", reversedList1.next.value);
		assertEquals("A", reversedList1.next.next.value);
		assertNull(reversedList1.next.next.next);

		// Test Case 2: Reverse an empty list
		MyRawLinkedList.Node list2 = null;
		MyRawLinkedList.Node reversedList2 = MyRawLinkedList.reverse(list2);
		assertNull(reversedList2);

		// Test Case 3: Reverse a list with a single node
		MyRawLinkedList.Node list3 = new MyRawLinkedList.Node("A", null);
		MyRawLinkedList.Node reversedList3 = MyRawLinkedList.reverse(list3);
		assertEquals("A", reversedList3.value);
		assertNull(reversedList3.next);

		// Test Case 4: Reverse a list with null values
		MyRawLinkedList.Node list4 = new MyRawLinkedList.Node(null, new MyRawLinkedList.Node("B", new MyRawLinkedList.Node(null, null)));
		MyRawLinkedList.Node reversedList4 = MyRawLinkedList.reverse(list4);
		assertNull(reversedList4.value);
		assertEquals("B", reversedList4.next.value);
		assertNull(reversedList4.next.next.value);
		assertNull(reversedList4.next.next.next);

		// Test Case 5: Reverse a list with large number of nodes
		MyRawLinkedList.Node list5 = new MyRawLinkedList.Node("A", null);
		MyRawLinkedList.Node current = list5;
		for (char c = 'B'; c <= 'Z'; c++) {
			current.next = new MyRawLinkedList.Node(String.valueOf(c), null);
			current = current.next;
		}
		MyRawLinkedList.Node reversedList5 = MyRawLinkedList.reverse(list5);
		for (char c = 'Z'; c >= 'A'; c--) {
			assertEquals(String.valueOf(c), reversedList5.value);
			reversedList5 = reversedList5.next;
		}
		assertNull(reversedList5);

	}

}

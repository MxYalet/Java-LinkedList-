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

class MyLinkedListTest {
	
	@Test
	void testContainsSubsequence() {
		// TODO
		/* 
		 * Write at least 5 assert test case that test your 'containsSubsequence' method
		 * Review the homework instructions and write assert test realated the this methods specification
		 * All 5 assert statements MUST pass.
		 */
		// Test Case 1: Both lists are empty
		MyLinkedList list1 = new MyLinkedList();
		MyLinkedList list2 = new MyLinkedList();
		assertNull(list1.containsSubsequence(list2));

		// Test Case 2: Current list contains the other list as a subsequence
		MyLinkedList list4 = new MyLinkedList();
		list4.addLast("A");
		list4.addLast("B");
		list4.addLast("C");
		MyLinkedList list5 = new MyLinkedList();
		list5.addLast("B");
		list5.addLast("C");
		assertTrue(list4.containsSubsequence(list5));

		// Test Case 3: Current list does not contain the other list as a subsequence
		MyLinkedList list6 = new MyLinkedList();
		list6.addLast("A");
		list6.addLast("B");
		list6.addLast("C");
		MyLinkedList list7 = new MyLinkedList();
		list7.addLast("B");
		list7.addLast("A");
		assertFalse(list6.containsSubsequence(list7));

		// Test Case 4: Other list is null
		MyLinkedList list8 = new MyLinkedList();
		list8.addLast("A");
		list8.addLast("B");
		list8.addLast("C");
		assertNull(list8.containsSubsequence(null));

		// Test Case 5: Current list and other list have single elements
		MyLinkedList list9 = new MyLinkedList();
		list9.addLast("A");
		MyLinkedList list10 = new MyLinkedList();
		list10.addLast("B");
		assertFalse(list9.containsSubsequence(list10));



	}

	@Test
	void testRemoveMaximumValues() {
		// TODO
		/* 
		 * Write at least 5 assert test case that test your 'removeMaximumValues' method
		 * Review the homework instructions and write assert test realated the this methods specification
		 * All 5 assert statements MUST pass.
		 */
		// Test Case 1: Remove maximum value from an empty list
		MyLinkedList list1 = new MyLinkedList();
		list1.removeMaximumValues(1);
		assertEquals(0, list1.size);

		// Test Case 2: Remove maximum value from a list with a single element
		MyLinkedList list2 = new MyLinkedList();
		list2.addLast("A");
		list2.removeMaximumValues(1);
		assertEquals(0, list2.size);

		// Test Case 3: Remove maximum value from a list with multiple occurrences of the maximum value
		MyLinkedList list3 = new MyLinkedList();
		list3.addLast("A");
		list3.addLast("B");
		list3.addLast("A");
		list3.removeMaximumValues(1);
		assertEquals(1, list3.size);
		assertFalse(list3.contains("A"));

		// Test Case 4: Remove multiple maximum values from a list
		MyLinkedList list4 = new MyLinkedList();
		list4.addLast("A");
		list4.addLast("B");
		list4.addLast("B");
		list4.addLast("A");
		list4.addLast("B");
		list4.removeMaximumValues(2);
		assertEquals(2, list4.size);
		assertFalse(list4.contains("B"));


		// Test Case 5: Remove maximum values from a list where the maximum value appears multiple times consecutively
		MyLinkedList list6 = new MyLinkedList();
		list6.addLast("A");
		list6.addLast("A");
		list6.addLast("B");
		list6.addLast("B");
		list6.addLast("A");
		list6.removeMaximumValues(2);
		assertEquals(2, list6.size);
		assertFalse(list6.contains("A"));

		
	}

	@Test
	void testReverse() {
		// TODO
		/* 
		 * Write at least 5 assert test case that test your 'reverse' method
		 * Review the homework instructions and write assert test realated the this methods specification
		 * All 5 assert statements MUST pass.
		 */
		// Test Case 1: Reverse an empty list
		MyLinkedList list1 = new MyLinkedList();
		list1.reverse();
		assertEquals(0, list1.size);
		assertNull(list1.head);
		assertNull(list1.tail);

		// Test Case 2: Reverse a list with a single element
		MyLinkedList list2 = new MyLinkedList();
		list2.addLast("A");
		list2.reverse();
		assertEquals(1, list2.size);
		assertEquals("A", list2.get(0));
		assertEquals("A", list2.head.value);
		assertEquals("A", list2.tail.value);

		// Test Case 3: Reverse a list with multiple elements
		MyLinkedList list3 = new MyLinkedList();
		list3.addLast("A");
		list3.addLast("B");
		list3.addLast("C");
		list3.reverse();
		assertEquals(3, list3.size);
		assertEquals("C", list3.get(0));
		assertEquals("B", list3.get(1));
		assertEquals("A", list3.get(2));
		assertEquals("C", list3.head.value);
		assertEquals("A", list3.tail.value);

		// Test Case 4: Reverse a list with null values
		MyLinkedList list4 = new MyLinkedList();
		list4.addLast("A");
		list4.addLast(null);
		list4.addLast("C");
		list4.reverse();
		assertEquals(3, list4.size);
		assertEquals("C", list4.get(0));
		assertNull(list4.get(1));
		assertEquals("A", list4.get(2));
		assertEquals("C", list4.head.value);
		assertEquals("A", list4.tail.value);

		// Test Case 5: Reverse a list with a large number of elements
		MyLinkedList list5 = new MyLinkedList();
		for (int i = 0; i < 1000; i++) {
			list5.addLast(String.valueOf(i));
		}
		list5.reverse();
		assertEquals(1000, list5.size);
		assertEquals("999", list5.get(0));
		assertEquals("0", list5.get(999));
		assertEquals("999", list5.head.value);
		assertEquals("0", list5.tail.value);


	}
}

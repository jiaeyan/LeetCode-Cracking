package twopointers;

/*
 * Write a program to find the node at which the intersection 
 * of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * A:      a1 → a2
 *                 ↘
 *                   c1 → c2 → c3
 *                 ↗            
 * B: b1 → b2 → b3
 * 
 * begin to intersect at node c1.
 * 
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */

/*
 * This case never happens, because c3 only has one next field:
 * 
 *  * A:     a1 → a2             a3 → a4 → a5
 *                ↘            ↗
 *                  c1 → c2 → c3
 *                ↗            ↘
 * B:     b1 → b2 → b3           b4 → b5
 * 
 */
public class Intersection {
	
	public class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) { val = x; }
	}
	
	/*
	 * Two pointers.
	 * 
	 * A: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
	 * B:           7 -> 4 -> 5 -> 6 -> null
	 * 
	 * We need to reserve heads of both lists, so we set a and b to
	 * represent given heads of A and B.
	 * 
	 * Move a and b, b will reach the end first, at that time a = 5,
	 * while b = null, make b = headA, so a and b are in fact the same
	 * list now. Now the rest length of a is in fact the length difference
	 * between headA and headB (5 to null). 
	 * 
	 * Then keep moving a and b, when rest of a reaches the end, b
	 * already consumes the length difference to 3, then we reset a to
	 * headB, by this both pointers move together from the same point.
	 */
	public ListNode twoptrs(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		
		ListNode a = headA;
		ListNode b = headB;
		
		while(a != b) {
			a = a.next;
			b = b.next;
			// in case both of them become nulls
			if(a == b) return a;
			
			if(a == null) {
				a = headB;
			}
			else if(b == null) {
				b = headA;
			}
		}
		
		//a more concise way to do the same thing
		//if a & b have different len, then we will stop the loop after second iteration
//	    while(a != b){
	    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
//	        a = a == null? headB : a.next;
//	        b = b == null? headA : b.next;    
//	    }
	    
		return a;
	}
	
	
	/*
	 * Length Difference and Alignment.
	 * 
	 * Find the length difference between two lists, align them,
	 * then move both pointers together, if at some point they are
	 * the same, return that point; otherwise return null.
	 * 
	 * Time complexity: O(m+n+?)
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		
		// get list lengths of both lists
		int lenA = getLen(headA);
        int lenB = getLen(headB);
        
        // align the longer one with the shorter one, so the
        // pointers can move at the same length point
        if (lenA > lenB) {
        	    while (lenA != lenB) {
        	    	    headA = headA.next;
        	    	    lenA--;
        	    }
        }
        else {
        	   while (lenA != lenB) {
        		   headB = headB.next;
   	    	       lenB--;
        	   }
        }
        
        // move two pointers together and check if they
        // are the same
        while(headA != null) {
        	    if(headA == headB) return headA;
        	    headA = headA.next;
        	    	headB = headB.next;
        }
        
        return null;
    }
	
	public int getLen(ListNode node) {
		int i = 0;
		while(node != null) {
			node = node.next;
			i++;
		}
		return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package merge;

import definition.ListNode;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

/*
 * Note each node is sorted, which means we may consume the same 
 * node all the time to the end. E.g.: l1 = 1->45->67; l2 = 2->3->4->5->6
 */

public class Merge2LinkedLists {
	
	/*
	 * Set a prehead, and make this the final result. Since we should return
	 * prehead.next at last, we should not modify what if references to during
	 * the whole process, so we set another pointer curr to refer to current
	 * node in the prehead list.
	 * We compare the values from l1 and l2, connect the smaller one and move
	 * the taken one forward, then also move the curr pointer forward. Hence
	 * we keep consuming l1 and l2 all the time.
	 */
	public ListNode iterative(ListNode l1, ListNode l2) {
		ListNode prehead = new ListNode(-1);
		ListNode curr = prehead;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			}
			else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		// in case l1 or l2 is not exhaustedly consumed
		curr.next = l1 == null? l2 : l1;
        return prehead.next;
    }
	
	
	/*
	 * Compare the 1st nodes from l1 and l2, the bigger one becomes
	 * the head of the result, then cut l1, compare l1.next with l2...
	 * keep doing the same procedure, until either becomes null, thus
	 * the return the non-null one directly, which is at the middle or
	 * very end.
	 */
	public ListNode recursive(ListNode l1, ListNode l2) {
		// l1 is exhausted, l2 is not the given l2, it is some point of 
		// l2.next.next...
		if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
		// choose the bigger nodes form l1 and l2, cut the chosen one
        else if (l1.val < l2.val) {
            l1.next = recursive(l1.next, l2);
            return l1;
        }
        else {
            l2.next = recursive(l1, l2.next);
            return l2;
        }
	}
	
	public static void main(String[] args) {
		Merge2LinkedLists ml = new Merge2LinkedLists();
		ListNode l1 = new ListNode(1);
		System.out.println(l1.next);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l4.next = l5;
		l5.next = l6;
		ListNode res = ml.iterative(l1, l2);
//		System.out.println("done");
//		while(!res.next.equals(null)) {
//			System.out.println(res.val);
//			res = res.next;
//		}
	}

}

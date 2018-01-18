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

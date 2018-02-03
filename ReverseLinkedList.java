package prehead;

/*
 * Reverse a singly linked list.
 * 
 * Hint:
 * A linked list can be reversed either iteratively or recursively. 
 * Could you implement both?
 */
public class ReverseLinkedList {
	
	public class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) { val = x; }
	}
	/*
	 * Convert:
	 * 1 -> 2 -> 3 -> 4 -> 5 -> null
	 * To:
	 * null <- 1 <- 2 <- 3 <- 4 <- 5
	 * 
	 * We can consider break the original list into two parts
	 * all the way. Once we traverse to a new node, we break the
	 * list here, make this node the parent of all previous nodes,
	 * then make the next node of current node the starting point
	 * for next traversal.
	 * 
	 * res: the reversed result of previous list
	 * cur: current traversed node
	 */
	public ListNode iterative(ListNode head) {
		// set a prehead as null
		ListNode res = null;
		ListNode cur = head;
		
		while(cur != null){
			// find the next node of current node
			ListNode tempNext = cur.next;
			// make current node the parent of all previous nodes
			cur.next = res;
			// move the result list's head to current node
			res = cur;
			// move forward of the linked list
			cur = tempNext;
		}
		return res;
	}
	
	/*
	 * Of course we can make above iterative solution to a tail-recursive
	 * function, but that is not the point here. Our goal here is not to create
	 * another called recursive function.
	 * 
	 * 1 -> 2 -> 3 -> 4 -> 5 -> null
	 * 
	 * We do this backwards, assume we already have this:
	 * 1 -> 2 -> 3 <- 4 <- 5
	 * 
	 * Now we want to make 3's next becomes 2, like:
	 * 1 -> 2 <- 3 <- 4 <- 5
	 * 
	 * So we need to do:
	 * 2.next.next = 2    ---> try to understand this hard, this line is crucial
	 * 
	 * 
	 * Now 2 is the last node of result list. After this, still have to set:
	 * 2.next = null
	 * 
	 * Otherwise 2.next = 3, forming a cycle
	 */
	
	// current given head will become the tail of new reversed list
	public ListNode recursive(ListNode head) {
		if (head == null || head.next == null) return head;
		
		// this line keeps moving forward till the last node of the list,
		// and p will remain as the last node and be returned, at last,
		// it will be returned as the head of the reversed list, thus the result
	    
		// each recursive() function call corrects one node backwards
		ListNode p = recursive(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

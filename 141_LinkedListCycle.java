package twopointers;

/*
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {
	
	public class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) { val = x; }
	}
	
	/*
	 * Set two pointers, one moves 1 step, another one moves 2 steps
	 * at each time, if there is a cycle, they will finally meet;
	 * if no, the fast one will reach the end first.
	 * 
	 * Time complexity : O(n). Let us denote n as the total number of nodes 
	 * in the linked list. To analyze its time complexity, we consider the following two cases separately.
	 * 
	 * List has no cycle:
	 * The fast pointer reaches the end first and the run time depends on the list's length, which is O(n).
	 * 
	 * List has a cycle:
	 * We break down the movement of the slow pointer into two steps, the non-cyclic part and the cyclic part:
	 * 
	 * The slow pointer takes "non-cyclic length" steps to enter the cycle. At this point, the fast pointer has already reached the cycle. 
	 * Number of iterations=non-cyclic length=N
	 * 
	 * Both pointers are now in the cycle. Consider two runners running in a cycle - the fast runner moves 2 steps while the slow runner 
	 * moves 1 steps at a time. Since the speed difference is 1, it takes 
	 * distance between the 2 runners / difference of speed loops for the fast runner to catch up with the slow runner. As the distance 
	 * is at most "cyclic length K" and the speed difference is 1, we conclude that Number of iterations = almost ‘‘cyclic length K".
	 * 
	 * Therefore, the worst case time complexity is O(N+K), which is O(n).
	 * 
	 * Space complexity : O(1). We only use two nodes (slow and fast) so the space complexity is O(1).
	 */
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) return false;
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(slow != fast) {
			if(fast == null || fast.next == null) return false;
			slow = slow.next;
			fast = fast.next.next;
		}
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

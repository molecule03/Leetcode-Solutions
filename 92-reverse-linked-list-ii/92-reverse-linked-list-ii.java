/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null) return head;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode pre = dummy;
        for(int i=0; i<left-1; i++)
            pre = pre.next;
        
        // System.out.println(pre.val);
        
        ListNode start = pre.next;
        ListNode then = start.next;
        
        for(int i=0; i<right-left; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}
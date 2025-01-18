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
        ListNode dnode =new ListNode(-1);
        dnode.next=head;
        ListNode prev=dnode;
        for(int i=1;i<left;i++){
            prev=prev.next;
        }
        ListNode curr=prev.next;
        for(int i=1;i<=right-left;i++){
            ListNode temp=prev.next;
            prev.next=curr.next;
            curr.next=curr.next.next;
            prev.next.next=temp;
        }
        return dnode.next;
    }
}
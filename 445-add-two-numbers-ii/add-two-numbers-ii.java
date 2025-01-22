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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if((l1.val==0&&l1.next==null)&&(l2.val==0&&l2.next==null)){
            return new ListNode(0);
        }
        ListNode temp1=reverse(l1);
        ListNode temp2=reverse(l2);
        int sum=0;
        int carry=0;
        ListNode curr=null;
        while(temp1!=null||temp2!=null||carry>0){
            int v1=temp1!=null?temp1.val:0;
            int v2=temp2!=null?temp2.val:0;
            sum=v1+v2+carry;
            carry=sum/10;
            ListNode temp=new ListNode(sum%10);
            temp.next=curr;
            curr=temp;
            if(temp1!=null){
                temp1=temp1.next;
            }
            if(temp2!=null){
                temp2=temp2.next;
            }
        }
        while(curr!=null&&curr.val==0){
            curr=curr.next;
        }
        return curr;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode nextnode=head;
        while(nextnode!=null){
            nextnode=nextnode.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        head=prev;
        return head;
    }
}
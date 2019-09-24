package leetcode.easy;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseLinkedList {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if(head != null) {
            ListNode node = new ListNode(head.val), temp = head;
            while(temp.next != null){
                ListNode next = temp.next;
                temp = next;
                ListNode copy = new ListNode(next.val);
                copy.next = node;
                node = copy;
            }
            return node;
        }
        return head;
    }

}

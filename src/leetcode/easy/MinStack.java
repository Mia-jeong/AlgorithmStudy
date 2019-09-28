package leetcode.easy;

import java.util.NoSuchElementException;

public class MinStack {
    /** initialize your data structure here. */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    int size = 0;
    ListNode head;
    public MinStack() {
        head = null;
    }

    public void push(int x) {
        ListNode l = new ListNode(x);
        if(head != null) {
            l.next = head;
        }
        head = l;
        size++;
    }

    public void pop() {
        if(size == 0) throw new NoSuchElementException();

        head = head.next;
        size--;
    }

    public int top() {
        if(size == 0) throw new NoSuchElementException();
        return head.val;
    }

    public int getMin() {
        ListNode temp = head;
        int min = Integer.MAX_VALUE;
        while(temp != null){
            if(temp.val < min) min = temp.val;
            temp = temp.next;
        }
        return min;
    }
}

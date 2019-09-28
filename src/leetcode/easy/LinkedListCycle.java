package leetcode.easy;

import java.util.HashMap;

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Boolean> map = new HashMap<>();
        ListNode start = head;
        while(start != null) {
            if(map.get(start) != null) return true;
            map.put(start, true);
            start = start.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode turtle = head, rabbit = head;
        while(rabbit != null &&  rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if(turtle == rabbit) return true;
        }
        return false;
    }
}

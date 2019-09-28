package leetcode.easy;

public class IntersectionOfTwoLinkedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        while(a != null){
            ListNode b = headB;
            while(b!= null){
                if(a == b)return a;
                b = b.next;
            }
            a = a.next;
        }
        return null;
    }
    //solution1 in discussion
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int aLen =0, bLen = 0;
        while(a != null){
            a = a.next;
            aLen++;
        }
        while(b != null){
            b = b.next;
            bLen++;
        }
        // aLen = 5, bLen = 6
        //a [4,1,8,4,5]
        //b [5,0,1,8,4,5] > [0,1,8,4,5]
        a = headA;
        b = headB;
        if(aLen > bLen){
            for (int i = 0; i < aLen-bLen; i++) a = a.next;
        }else {
            for (int i = 0; i < bLen-aLen; i++) b = b.next;
        }
        while(a != b){
            a = a.next;
            b = b.next;
        }
        return a;
    }
    //solution2 in discussion
    //make circle
    /*
    A:         a1 → a2
                   ↘
                     c1 → c2 → c3 \
                   ↗              |
    B:    b1 → b2 → b3            /
        ↖------------------------
    * */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode endA = headA;
        while(endA.next != null){
            endA = endA.next;
        }
        endA.next = headB; // make circle from intersection to headB
        ListNode start = null;
        //find circle
        ListNode turtle = headA, rabbit =headA;
        while(rabbit != null && rabbit.next != null){
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if(turtle == rabbit) {
                start = headA;
                while(turtle != start){
                    turtle = turtle.next;
                    start = start.next;
                }
                break;
            }
        }
        endA.next = null;
        return start;
    }

}

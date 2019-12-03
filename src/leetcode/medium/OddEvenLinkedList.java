package leetcode.medium;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if(head != null) {
            ListNode oddTail = head;
            ListNode evenHead = head.next;
            ListNode evenTail = evenHead;

            while (evenTail != null && evenTail.next != null) {
                oddTail.next = evenTail.next;
                oddTail = oddTail.next;
                evenTail.next = oddTail.next;
                evenTail = evenTail.next;
            }

            oddTail.next = evenHead;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = oddEvenList(head);

    }
}

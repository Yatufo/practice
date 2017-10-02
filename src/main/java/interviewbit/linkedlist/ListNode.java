package interviewbit.linkedlist;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; this.next = null; }
    ListNode(int x, ListNode next) { val = x; this.next = next; }
    public static ListNode create(List<Integer> elements) {
        ListNode head = new ListNode(0), previous = head;
        for (Integer e : elements) {
            previous.next = new ListNode(e);
            previous = previous.next;
        }
        return head.next;
    }
    public void print(){
        ListNode next = this;
        Integer count = 0;
        while (next != null || count > 100){
            System.out.print(next.val + ", ");
            next = next.next;
            count++;
        }
        System.out.println("");
    }
}

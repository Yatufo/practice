package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;


public class MergeSorted {

    public static void main(String[] args) {
        MergeSorted s = new MergeSorted();

        List<Integer> a1 = Arrays.asList(7,6,6,6,6,1);
        List<Integer> a2 = Arrays.asList(8,8,8,8,8,6,5,4);

        s.mergeTwoLists(getListNode(a1), getListNode(a2));
    }

    private static ListNode getListNode(List<Integer> elements) {
        ListNode next = null;
        for (Integer e : elements) {
            next = new ListNode(e, next);
        }
        return next;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head = new ListNode(Integer.MIN_VALUE), previous = head, current = a, next = b;

        while (current != null || next != null) {
            if (current == null || (next != null && next.val <= current.val)){
                ListNode swap = next;
                next = current;
                current = swap;
            }

            previous.next = new ListNode(current.val);
            previous = previous.next;
            current = current.next;
            head.print();
        }

        return head.next;
    }
}

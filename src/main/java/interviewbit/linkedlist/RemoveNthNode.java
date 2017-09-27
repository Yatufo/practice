package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;


public class RemoveNthNode {

    public static void main(String[] args) {
        RemoveNthNode s = new RemoveNthNode();
        List<Integer> a1 = Arrays.asList(1,2,3,4,5);

        s.removeNthFromEnd(getListNode(a1), 5);
    }

    private static ListNode getListNode(List<Integer> elements) {
        ListNode next = null;
        for (Integer e : elements) {
            next = new ListNode(e, next);
        }
        return next;
    }

    public ListNode removeNthFromEnd(ListNode a, int removed) {
        ListNode head = a, locator = a;
        int size = size(a);
        if (size <= removed){
            head = head.next;
        } else {
            for(int i=1; i< size - removed; i++) {
                locator = locator.next;
            }
            locator.next = locator.next.next;
        }
        head.print();
        return head;
    }

    private int size(final ListNode node) {
        ListNode next = node;
        int count = 0;
        while(next != null){
            count ++;
            next = next.next;
        }
        return count;
    }
}

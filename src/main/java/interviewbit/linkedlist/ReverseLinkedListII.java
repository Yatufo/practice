package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;


public class ReverseLinkedListII {

    public static void main(String[] args) {
        ReverseLinkedListII s = new ReverseLinkedListII();
        List<Integer> a1 = Arrays.asList(5,4,3,2,1);

        s.reverseBetween(getListNode(a1), 3,5);
    }

    private static ListNode getListNode(List<Integer> elements) {
        ListNode next = null;
        for (Integer e : elements) {
            next = new ListNode(e, next);
        }
        return next;
    }

    public ListNode reverseBetween(ListNode node, int m, int n) {
        if (m == n)
            return node;
        ListNode head = new ListNode(0, node), current = head, prestart = null, start = null, previous = null, next = current.next;

        for(int i = 0; i < n; i++){
            if (i == m){
                prestart = previous;
                start = current;
            } else if (i > m){
                current.next = previous;
            }

            previous = current;
            current = next;
            next = next.next;
        }

        current.next = previous;
        start.next = next;
        prestart.next = current;

        head.print();
        return head.next;
    }
}

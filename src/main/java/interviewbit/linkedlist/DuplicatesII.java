package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;


public class DuplicatesII {

    public static void main(String[] args) {
        DuplicatesII s = new DuplicatesII();

        List<Integer> elements = Arrays.asList(5,5,5,3,4,4,4,2,6,6,1);
        //List<Integer> elements = Arrays.asList(6,6,6);

        ListNode next = null;
        for (Integer e : elements) {
            next = new ListNode(e, next);
        }

        s.deleteDuplicates(next);
    }

    public ListNode deleteDuplicates(ListNode node) {
        ListNode head = new ListNode(node.val - 1), good = head, previous = null, current = node, next = node.next;
        while (current != null) {
            if((previous == null || previous.val != current.val) && (next == null || current.val != next.val)){
                good.next = new ListNode(current.val);
                good = good.next;
            }
            previous = current;
            current = next;
            next = getNext(current);
        }

        return head.next;
    }

    private ListNode getNext(ListNode node) {
        return node != null ? node.next : null;
    }

}

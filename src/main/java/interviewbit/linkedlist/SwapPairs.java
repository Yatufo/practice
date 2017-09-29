package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;


public class SwapPairs {

    public static void main(String[] args) {
        SwapPairs s = new SwapPairs();
        List<Integer> a1 = Arrays.asList(1,2,3,4,5);

        s.swapPairs(ListNode.create(a1));
    }

    public ListNode swapPairs(final ListNode node) {
        ListNode head = new ListNode(0), current = node, next, end = head;
        while (current != null){
            next = current.next;
            if (next != null){
                ListNode rest = next.next;
                next.next = current;
                end.next = next;
                current.next = null;

                end = current;
                current = rest;
            } else{
                end.next = current;
                current = null;
            }
        }

        head.print();
        return head;
    }

}

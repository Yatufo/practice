package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;


public class ReverseKElement {

    public static void main(String[] args) {
        ReverseKElement s = new ReverseKElement();
        List<Integer> a1 = Arrays.asList(1,2,3,4,5,6,7,8);

        s.reverseBetween(ListNode.create(a1), 8);
    }

    public ListNode reverseBetween(ListNode node, int k) {
        int size = size(node);
        int realK = k % size;
        if (realK == 1)
            return node;

        ListNode head = new ListNode(0), current = node, previous = null, prevEnd = node, end = null;
        int step = 1;
        while (current != null) {

            ListNode next = current.next;
            current.next = previous;
            previous = current;

            if(size == step || (realK > 0 && step % realK == 0)){

                if (end != null){
                    end.next = current;
                }

                end = prevEnd;
                prevEnd = next;

                if (head.next == null){
                    head.next = current;
                }
            }

            current = next;
            step++;
        }

        if(end != null){
            end.next = null;
        }

        head.print();
        return head.next;
    }

    private int size(final ListNode node) {
        ListNode next = node;
        int size = 0;
        while(next != null){
            next = next.next;
            size ++;
        }
        return  size;
    }
}

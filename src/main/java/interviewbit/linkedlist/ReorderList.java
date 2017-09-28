package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;


public class ReorderList {

    public static void main(String[] args) {
        ReorderList s = new ReorderList();
        List<Integer> a1 = Arrays.asList(1, 2, 3, 4, 5,6);
        ListNode.create(a1).print();
        s.rotateRight(ListNode.create(a1));
    }


    public ListNode rotateRight(ListNode node) {
        int size = size(node);
        int half = size / 2;
        int firstHalf = half + size % 2;
        ListNode head = new ListNode(0), current = node, previous = head ;
        head.next = current;

        for (int i = 1; i <= firstHalf; i ++){
            previous = current;
            current = current.next;
        }

        previous.next = null;
        previous = null;

        while(current != null){
            ListNode next = current.next;
            current.next = null;

            current.next = previous;

            previous = current;
            current = next;
        }


        ListNode next = head.next, other = previous;
        while (next != null){
            ListNode temp = next.next;
            next.next = other;
            next = other;
            other = temp;
        }

        head.print();
        return head.next;
    }

    private int size(final ListNode node) {
        ListNode next = node;
        int size = 0;
        while(next != null){
            size ++;
            next = next.next;
        }
        return size;
    }
}

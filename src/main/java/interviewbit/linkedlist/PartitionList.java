package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.HashSet;


public class PartitionList {

    public static void main(String[] args) {
        PartitionList s = new PartitionList();
        ListNode a1 = ListNode.create(Arrays.asList(1, 4, 3, 2, 5, 2));
        s.partition(a1, 8);
    }

    public ListNode partition(ListNode a, int b) {

        ListNode current = a, greater = new ListNode(0), smaller = new ListNode(0), headSmaller = smaller, headGreater = null;
        while (current != null) {
            if (current.val < b) {
                smaller.next = current;
                smaller = smaller.next;
            } else {
                greater.next = current;
                greater = greater.next;

                if(headGreater == null){
                    headGreater = greater;
                }
            }

            current = current.next;
        }

        smaller.next = headGreater;
        greater.next = null;
        headSmaller.next.print();

        return headSmaller.next;
    }
}

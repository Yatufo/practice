package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;


public class Substract {

    public static void main(String[] args) {
        Substract s = new Substract();
        List<Integer> a1 = Arrays.asList(1,2,3,4);

        s.subtract(ListNode.create(a1));
    }

    public ListNode subtract(ListNode node) {
        ListNode head = new ListNode(0), right = node;
        int size = size(node);
        int middle = size / 2;
        for (int i=1; i <= middle; i++){
            right = right.next;
        }

        ListNode revRight = copyReverse(right);
        ListNode previous = head, left = node, current;
        for (int i=1; i <= middle; i++){
            current = new ListNode(revRight.val - left.val);
            previous.next = current;
            previous = current;
            left = left.next;
            revRight = revRight.next;
        }
        previous.next = right;

        head.print();
        return head.next;
    }

    private ListNode copyReverse(ListNode node) {
        ListNode current = node, previousClone = null, clone;
        while(current != null){
            clone = new ListNode(current.val);
            clone.next = previousClone;
            previousClone = clone;
            current = current.next;
        }
        return previousClone;
    }

    private int size(ListNode node) {
        int size = 0;
        ListNode current = node;
        while (current != null){
            size ++;
            current = current.next;
        }
        return size;
    }

}

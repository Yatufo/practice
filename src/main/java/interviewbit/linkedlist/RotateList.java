package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;


public class RotateList {

    public static void main(String[] args) {
        RotateList s = new RotateList();
        List<Integer> a1 = Arrays.asList(5,4,3,2,1);

        s.rotateRight(getListNode(a1), 5);
    }

    private static ListNode getListNode(List<Integer> elements) {
        ListNode next = null;
        for (Integer e : elements) {
            next = new ListNode(e, next);
        }
        return next;
    }

    public ListNode rotateRight(ListNode node, int cut) {
        ListNode locator = node, next = node, last = node, head = node;
        int size = 0;
        while(next != null){
            size ++;
            last = next;
            next = next.next;
        }
        int realCut = cut % size;
        if (size > realCut){
            for(int i=1; i < size - realCut; i++) {
                locator = locator.next;
            }

            last.next = head;
            head = locator.next;
            locator.next = null;
        }
        head.print();
        return head;
    }
}

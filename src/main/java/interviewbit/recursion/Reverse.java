package interviewbit.recursion;

import interviewbit.linkedlist.ListNode;

import java.util.Arrays;
import java.util.List;


public class Reverse {

    public static void main(String[] args) {
        Reverse s = new Reverse();
        List<Integer> a1 = Arrays.asList(1,2,3);

        s.reverseList(ListNode.create(a1));
    }

    public ListNode reverseList(ListNode node) {
        ListNode result = node, next = node.next;
        if (next != null){
            node.next = null;
            result = reverseList(next);
            next.next = node;
        }

        result.print();
        return result;
    }
}

package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.HashSet;


public class ListCycle {

    public static void main(String[] args) {
        ListCycle s = new ListCycle();
        ListNode a1 = ListNode.create(Arrays.asList(1,2));
        a1.next.next = a1.next;
        s.detectCycle(a1);
    }

    public ListNode detectCycle(ListNode a) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode current = a, previous = null;
        while (current != null) {
            visited.add(current);
            ListNode next = current.next;
            current.next = previous;


            if (visited.contains(next)) {
                return next;
            }

            previous = current;
            current = next;
        }

        return null;
    }

}

package interviewbit.linkedlist;

import java.util.Arrays;


public class ListAddition {

    public static void main(String[] args) {
        ListAddition s = new ListAddition();
        ListNode a1 = ListNode.create(Arrays.asList(1));
        ListNode a2 = ListNode.create(Arrays.asList(9,9));

        s.addTwoNumbers(a1, a2);
    }

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        int carry = 0;
        ListNode left = a, right = b, head = new ListNode(0), previous = head, current;
        while(left != null || right != null || carry > 0){
            int total = carry;

            if (left != null){
                total += left.val;
                left = left.next;
            }

            if (right != null){
                total += right.val;
                right = right.next;
            }

            int digit = total % 10;
            carry = (total - digit) / 10;
            current = new ListNode(digit);
            previous.next = current;
            previous = current;
        }

        head.next.print();
        return head.next;
    }


    private ListNode reverse(ListNode node) {
        ListNode next = node, current = null;
        while(next != null){
            ListNode rest = next.next;
            next.next = current;
            current = next;
            next = rest;
        }
        return current == null ? node : current;
    }

}

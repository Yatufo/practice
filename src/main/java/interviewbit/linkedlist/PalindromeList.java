package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;


public class PalindromeList {

    public static void main(String[] args) {
        PalindromeList s = new PalindromeList();

        List<Integer> elements = Arrays.asList(22, 16, 16, 8, 16, 22);
        //List<Integer> elements = Arrays.asList(6,6,6);

        ListNode next = null;
        for(Integer e: elements){
            next = new ListNode(e, next);
        }

        s.lPalin(next);
    }
    public int lPalin(final ListNode node) {

        Integer count = count(node);

        boolean isOdd = count % 2 == 1;
        int middle = count / 2;
        ListNode leftSide = null;
        ListNode rightSide = node;
        for(int i = 1; i<= middle; i++){
            ListNode temp = rightSide.next;
            rightSide.next = leftSide;
            leftSide = rightSide;
            rightSide = temp;
        }

        if (isOdd){
            rightSide = rightSide.next;
        }

        if (equals(leftSide, rightSide)) {
            return 1;
        }


        return 0;
    }

    private Integer count(ListNode node) {
        Integer count = 1;
        ListNode current = node.next;
        while(current != null){
            current = current.next;
            count ++;
        }
        return count;
    }

    private boolean equals(final ListNode leftSide, final ListNode rightSide) {
        ListNode ls = leftSide, rs = rightSide;
        while(ls != null && rs != null && ls.val == rs.val){
            ls = ls.next;
            rs = rs.next;
        }
        if(ls == null && rs == null){
            return true;
        }
        return false;
    }
}

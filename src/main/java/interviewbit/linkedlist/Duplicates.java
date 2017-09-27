package interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;


public class Duplicates {

    public static void main(String[] args) {
        Duplicates s = new Duplicates();

        List<Integer> elements = Arrays.asList(3,3,3,3,1);
        //List<Integer> elements = Arrays.asList(6,6,6);

        ListNode next = null;
        for(Integer e: elements){
            next = new ListNode(e, next);
        }

        s.deleteDuplicates(next);
    }
    public ListNode deleteDuplicates(ListNode node) {
        ListNode previous = node;
        ListNode next = node.next;
        while(next != null){
            if(next.val == previous.val){
                next = next.next;
                previous.next = null;
            } else{
                previous.next = next;
                previous = next;
            }
        }


        return node;
    }

}

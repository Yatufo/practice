package interviewbit.linkedlist;

import java.util.Arrays;


public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort s = new InsertionSort();
        ListNode a1 = ListNode.create(Arrays.asList(9,8,7));
        s.insertionSortList(a1);
    }

    public ListNode insertionSortList(ListNode a) {

        ListNode current = a, sorted = new ListNode(0);
        while (current != null) {
            ListNode next = current.next;

            ListNode currentSorted = sorted;
            while(currentSorted != null){
                ListNode nextSorted = currentSorted.next;
                if (nextSorted == null || nextSorted.val >= current.val){
                    current.next = nextSorted;
                    currentSorted.next = current;
                    currentSorted = null;
                } else{
                    currentSorted = currentSorted.next;
                }
            }

            current = next;
        }

        sorted.next.print();

        return sorted.next;
    }
}

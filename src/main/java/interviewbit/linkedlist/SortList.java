package interviewbit.linkedlist;

import java.util.Arrays;


public class SortList {

    public static void main(String[] args) {
        SortList s = new SortList();
        ListNode a1 = ListNode.create(Arrays.asList(9,8,7));
        s.insertionSortList(a1);
    }

    public ListNode insertionSortList(ListNode node) {

        ListNode current = node, head = new ListNode(0);
        while (current != null) {
            ListNode next = current.next;


            current = next;
        }

        head.next.print();

        return head.next;
    }

//        if (start >= 0 && end < input.length && end > start){
//        val pivot = input(end)
//        var leftMost = -1
//
//        for (i <- start to end) {
//            val current = input(i)
//            val canSwap = leftMost >= 0
//
//            if (current <= pivot && canSwap) {
//                input(i) = input(leftMost)
//                input(leftMost) = current
//                leftMost += 1
//            } else if (current > pivot && !canSwap) {
//                leftMost = i
//            }
//        }
//
//        println(input.mkString(" "))
//        // if there was no
//        val endLeft: Int = if (leftMost > 0) leftMost - 2 else end - 1
//        val startRight: Int = endLeft + 2
//        solve(input, start, endLeft)
//        solve(input, startRight, end)
//    }

}

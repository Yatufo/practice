package interviewbit.heapmaps;

import interviewbit.linkedlist.ListNode;

import java.util.*;


public class MergeSortedLists {

    public static void main(String[] args) {
        MergeSortedLists s = new MergeSortedLists();
        s.mergeKLists(Arrays.asList(ListNode.create(Arrays.asList(1 , 10 , 20)),
        ListNode.create(Arrays.asList(4 , 11 , 13)),
        ListNode.create(Arrays.asList(3 , 8 , 9))));


    }


    public ListNode mergeKLists(List<ListNode> nodes) {
        ListNode head = new ListNode(0), current = head;
        PriorityQueue<ListNode> nodesHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        nodesHeap.addAll(nodes);
        while(nodesHeap.size() > 0){
            ListNode min = nodesHeap.poll();
            if (min.next != null){
                nodesHeap.add(min.next);
            }
            current.next = min;
            current = current.next;
        }
        head.print();
        return head.next;
    }
}

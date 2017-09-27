package interviewbit.linkedlist;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; this.next = null; }
    ListNode(int x, ListNode next) { val = x; this.next = next; }
    void print(){
        ListNode next = this;
        Integer count = 0;
        while (next != null || count > 100){
            System.out.print(next.val + ", ");
            next = next.next;
            count++;
        }
        System.out.println("");
    }
}

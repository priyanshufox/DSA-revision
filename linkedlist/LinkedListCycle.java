package linkedlist;

public class LinkedListCycle {
     public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }

        return false;
        

    }
    public static void main(String[] args) {
        LinkedListCycle llc = new LinkedListCycle();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // Creates a cycle

        System.out.println(llc.hasCycle(head)); // Output: true
    }
}

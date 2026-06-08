package linkedlist;

public class MergeTwoLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode t1 = l1;
        ListNode t2 = l2;
        while(t1!=null && t2!=null){
            if(t1.val<=t2.val){
                temp.next = t1;
                temp = temp.next;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                temp = temp.next;
                t2 = t2.next;
            }
        }
        if(t1!=null){
            temp.next=t1;
        
        }
        else{
            temp.next=t2;
        }

        return dummy.next;

    }
    public static void main(String[] args) {
        MergeTwoLinkedList mt = new MergeTwoLinkedList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode mergedHead = mt.mergeTwoLists(l1, l2);
        ListNode.printList(mergedHead); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }
    
}

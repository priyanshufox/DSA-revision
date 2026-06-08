package linkedlist;

public class Add2Num {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int sum = carry ;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            int d = sum%10;
            temp.next = new ListNode(d);
            carry = sum/10;
            temp = temp.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Add2Num atn = new Add2Num();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode resultHead = atn.addTwoNumbers(l1, l2);
        ListNode.printList(resultHead); // Output: 7 -> 0 -> 8
    }
    
}

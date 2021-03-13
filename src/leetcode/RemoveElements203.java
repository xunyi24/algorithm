package leetcode;

public class RemoveElements203 {
    public static void main(String[] args) {
        RemoveElements203 removeElements203 = new RemoveElements203();
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);

        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode head = removeElements203.removeElements(l0, 10);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode indexNode = dummyHead;
        while (indexNode.next != null) {
            if (indexNode.next.val == val) {
                ListNode nextNode = indexNode.next;
                indexNode.next = nextNode.next;
                nextNode.next = null;
            } else {
                indexNode = indexNode.next;
            }
        }

        return dummyHead.next;
    }
}

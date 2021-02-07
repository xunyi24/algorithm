package leetcode;

public class RemoveNthFromEnd19 {
    public static void main(String[] args) {
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode l8 = l0;

        /**
         * 区别: 一个是给l8 重新赋值
         *      一个是给l8代表的引用赋值
         * l8 = l8.next;
         * l8.next = null;
         */


        while (l0 != null) {
            System.out.println(l0.val);
            l0 = l0.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < n - 1; i++) {
            if (second == null) {
                return head;
            }

            second = second.next;
        }

        if (second.next == null) {
            head = head.next;
            return head;
        }

        if (n == 1) {
            if (second.next.next == null) {
                head.next = null;
                return head;
            }

            while (second.next.next != null) {
                second = second.next;
            }

            second.next = null;
            return head;
        }

        while (second.next.next != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;

        return head;
    }
}
package leetcode;

public class IsPalindromeList234 {
    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        l0.next = l1;
        l1.next = l2;

        System.out.println(isPalindrome(l0));
        while (l0 != null) {
            System.out.println(l0.val);
            l0 = l0.next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode index1 = head;
        ListNode index2 = head;

        while (index2.next != null && index2.next.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
        }

        //奇数个节点
        if (index2.next == null) {
            //从中间开始反转链表，判断前部分和后部分
            ListNode reverseHead = reverseList(index1);
            //判断是否是回文链表
            boolean result = isPalindrome(head, reverseHead);
            //将反转后的链表重新反转为原来的链表(对于判断结果其实不需要这一步，但是实际应用中希望原先的链表不会变化的)
            reverseList(reverseHead);
            return result;
        }
        //偶数个节点
        if (index2.next.next == null) {
            ListNode reverseHead = reverseList(index1.next);
            boolean result = isPalindrome(head, reverseHead);
            reverseList(reverseHead);
            return result;
        }

        return false;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode reverseHead = head;
        ListNode preNode = null;

        while (reverseHead != null) {
            ListNode nextNode = reverseHead.next;
            reverseHead.next = preNode;
            preNode = reverseHead;
            reverseHead = nextNode;
        }

        return preNode;
    }

    private static boolean isPalindrome(ListNode l1, ListNode l2) {
        while (l1.next != l2.next && l2.next != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1.val == l2.val;
    }
}

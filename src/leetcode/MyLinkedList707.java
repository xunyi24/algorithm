package leetcode;

public class MyLinkedList707 {
    ListNode dummyHead;
    ListNode dummyTail;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList707() {
        size = 0;
        dummyHead = new ListNode(0);
        dummyTail = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode indexNode;

        if (index + 1 < size - index) {
            indexNode = dummyHead;
            for (int i = 0; i < index + 1; i++) {
                indexNode = indexNode.next;
            }
        } else {
            indexNode = dummyTail;
            for (int i = 0; i < size - index; i++) {
                indexNode = indexNode.pre;
            }
        }

        return indexNode.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        size++;
        ListNode newHead = new ListNode(val);
        ListNode head = dummyHead.next;
        if (head == null) {
            dummyHead.next = newHead;
            newHead.pre = dummyHead;
            newHead.next = dummyTail;
            dummyTail.pre = newHead;
        } else {
            head.pre = newHead;
            newHead.next = head;
            newHead.pre = dummyHead;
            dummyHead.next = newHead;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        size++;
        ListNode newTail = new ListNode(val);
        ListNode tail = dummyTail.pre;
        if (tail == null) {
            dummyTail.pre = newTail;
            newTail.next = dummyTail;
            newTail.pre = dummyHead;
            dummyHead.next = newTail;
        } else {
            tail.next = newTail;
            newTail.pre = tail;
            newTail.next = dummyTail;
            dummyTail.pre = newTail;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // If index is greater than the length,
        // the node will not be inserted.
        if (index > size) return;

        // [so weird] If index is negative,
        // the node will be inserted at the head of the list.
        if (index < 0) index = 0;

        // find predecessor and successor of the node to be added
        ListNode pred, succ;
        if (index < size - index) {
            pred = dummyHead;
            for(int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next;
        }
        else {
            succ = dummyTail;
            for (int i = 0; i < size - index; ++i) succ = succ.pre;
            pred = succ.pre;
        }

        // insertion itself
        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.pre = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.pre = toAdd;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        // find predecessor and successor of the node to be deleted
        ListNode pred, succ;
        if (index < size - index) {
            pred = dummyHead;
            for(int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next.next;
        }
        else {
            succ = dummyTail;
            for (int i = 0; i < size - index - 1; ++i) succ = succ.pre;
            pred = succ.pre.pre;
        }

        // delete pred.next
        --size;
        pred.next = succ;
        succ.pre = pred;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode pre;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }
}

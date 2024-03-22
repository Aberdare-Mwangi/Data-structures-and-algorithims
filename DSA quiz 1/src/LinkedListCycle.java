class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(0);
        ListNode fourthNode = new ListNode(-4);
        head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = secondNode;
        boolean hasCycle = hasCycle(head);
        if (hasCycle) {
            System.out.println("The linked list has a cycle.");
        } else {
            System.out.println("No cycle detected in the linked list.");
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycle {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // Use Floyd's Tortoise and Hare algorithm to detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true; // Cycle detected
                break;
            }
        }

        // If there is no cycle, return null
        if (!hasCycle) {
            return null;
        }

        // Move one pointer to the head and another pointer remains at the meeting point
        slow = head;

        // Move both pointers at the same pace; the meeting point will be the start of the cycle
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(0);
        ListNode fourthNode = new ListNode(-4);

        head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = secondNode; // Cycle back to the second node

        // Find the node where the cycle begins
        ListNode cycleStartNode = detectCycle(head);

        if (cycleStartNode != null) {
            System.out.println("Cycle starts at node with value: " + cycleStartNode.val);
        } else {
            System.out.println("No cycle detected in the linked list.");
        }
    }
}

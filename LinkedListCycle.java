public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;
        System.out.println(solution.hasCycle(head));
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        while (true) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null) {
                return false;
            }
            p2 = p2.next;
            if (p2 == null) {
                return false;
            }
            if (p1 == p2) {
                return true;
            }
        }
    }
}

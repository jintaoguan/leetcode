public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;
        System.out.println(solution.detectCycle(head).val);
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (true) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
            if (p2 == null) {
                return null;
            }
            if (p1 == p2) {
                break;
            }
        }
        p1 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

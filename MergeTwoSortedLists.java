public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode node = solution.mergeTwoLists(l1, l2);
        System.out.println(node.val);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                pre.next = p1;
                p1 = p1.next;
                pre = pre.next;
            } else {
                pre.next = p2;
                p2 = p2.next;
                pre = pre.next;
            }
        }
        if (p1 != null) {
            pre.next = p1;
        } else {
            pre.next = p2;
        }
        return dummy.next;
    }
}

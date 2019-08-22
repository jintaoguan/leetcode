public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode newHead = solution.swapPairs(l1);
        System.out.println(newHead.val);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (true) {
            ListNode next1 = pre.next;
            if (next1 == null) {
                break;
            }
            ListNode next2 = next1.next;
            if (next2 == null) {
                break;
            }
            ListNode next3 = next2.next;
            pre.next = next2;
            next2.next = next1;
            next1.next = next3;
            pre = next1;
        }
        return dummy.next;
    }
}

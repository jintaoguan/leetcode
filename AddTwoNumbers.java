public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode ans = solution.addTwoNumbers(l1, l2);
        System.out.println(ans.val);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int carry = 0;
        while (p1 != null || p2 != null || carry != 0) {
            int sum = 0;
            sum += carry;
            if (p1 != null) {
                sum += p1.val;
            }
            if (p2 != null) {
                sum += p2.val;
            }
            int digit = sum % 10;
            carry = sum / 10;
            pre.next = new ListNode(digit);
            pre = pre.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        return dummy.next;
    }
}

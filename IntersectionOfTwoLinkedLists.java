public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        ListNode head2 = new ListNode(1);
        head2.next = head1.next;
        System.out.println(solution.getIntersectionNode(head1, head2).val);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = 1;
        ListNode p1 = headA;
        while(p1.next != null) {
            lengthA++;
            p1 = p1.next;
        }
        int lengthB = 1;
        ListNode p2 = headB;
        while(p2.next != null) {
            lengthB++;
            p2 = p2.next;
        }
        if (p1 != p2) {
            return null;
        }
        p1 = headA;
        p2 = headB;
        int diff = Math.abs(lengthA - lengthB);
        for (int i = 1; i <= diff; i++) {
            if (lengthA > lengthB) {
                p1 = p1.next;
            } else {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

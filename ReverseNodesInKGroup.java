import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode newHead = solution.reverseKGroup(l1, 3);
        System.out.println(newHead.val);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode[] group = new ListNode[k];
        boolean end = false;
        while (true) {
            ListNode cur = pre.next;
            for (int i = 0; i < k; i++) {
                if (cur != null) {
                    group[i] = cur;
                    cur = cur.next;
                } else {
                    end = true;
                    break;
                }
            }
            if (end) {
                break;
            }
            ListNode tail = cur;
            for (int i = k - 1; i > 0; i--) {
                group[i].next = group[i-1];
            }
            pre.next = group[k-1];
            pre = group[0];
            group[0].next = tail;
        }
        return dummy.next;
    }
}

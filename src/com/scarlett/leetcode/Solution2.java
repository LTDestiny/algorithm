package com.scarlett.leetcode;

/**
 * @ClassName : Solution2
 * Description :
 * @Author : scarlett
 * @Date: 2020-06-09 10:48
 */
public class Solution2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode n = new Solution2().addTwoNumbers(l1, l2);
        System.out.println(n.val);
        System.out.println(n.next.val);
        System.out.println(n.next.next.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int curry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + curry;
            curry = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (curry == 1) {
            cur.next = new ListNode(curry);
        }
        return pre.next;
    }
}

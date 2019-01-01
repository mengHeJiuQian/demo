package com.nowcoder.www.链表中倒数第k个结点;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2018/12/31 15:29
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode FindKthToTail(ListNode head,int k) {
        if (null == head || 0 == k) {
            return null;
        }
        // p1比p2先走 k-1 步
        ListNode p1 = head, p2 = head;
        for (int i = 0; i< k - 1; i++) {
            if (null == p1.next) {
                return null;
            }
            p1 = p1.next;
        }
        while (null != p1.next) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Solution solution = new Solution();
        ListNode res = solution.FindKthToTail(l1, 0);

        System.out.println(res.val);
    }

}

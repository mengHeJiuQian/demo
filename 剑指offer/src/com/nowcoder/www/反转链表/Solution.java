package com.nowcoder.www.反转链表;

import java.util.ArrayList;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2018/12/29 22:29
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode hNext = head.next;
        ListNode newHead = head;
        newHead.next = null;
        ListNode tmp;
        while (hNext != null) {
            tmp = hNext;
            hNext = hNext.next;
            tmp.next = null;

            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        Solution solution = new Solution();
        ListNode res = solution.ReverseList(l1);

        while (null != res) {
            System.out.println(res.val);
            res = res.next;
        }



    }

}

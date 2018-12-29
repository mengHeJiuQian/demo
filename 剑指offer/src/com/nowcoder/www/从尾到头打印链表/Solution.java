package com.nowcoder.www.从尾到头打印链表;


import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class Solution {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode reverse = ReverseList(listNode);
        ArrayList res = new ArrayList();
        while (null != reverse) {
            res.add(reverse.val);
            reverse = reverse.next;
        }
        return res;
    }

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
        ArrayList<Integer> res = solution.printListFromTailToHead(l1);
        System.out.println(res);


    }
}

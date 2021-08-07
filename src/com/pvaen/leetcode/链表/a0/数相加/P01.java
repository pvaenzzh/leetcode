package com.pvaen.leetcode.链表.a0.数相加;


import com.pvaen.leetcode.链表.a0.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/submissions/
 * 2 ms	38.4 MB	Java	2021/08/07 00:02
 */
public class P01 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(6, new ListNode(9, new ListNode(6)));
        ListNode listNode2 = new ListNode(5, new ListNode(1));

        ListNode listNode = new P01().addTwoNumbers(listNode1, listNode2);

        System.out.println(listNode);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode startNode = new ListNode();
        ListNode tmpNode = startNode;

        int preSum = l1.val + l2.val;
        int nowSun;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 != null) {
            tmpNode.val = preSum % 10;

            nowSun = getValue(l1) + getValue(l2);
            if (preSum / 10 > 0) nowSun++;

            tmpNode.next = new ListNode();
            tmpNode = tmpNode.next;
            l1 = getNext(l1);
            l2 = getNext(l2);

            preSum = nowSun;
        }

        tmpNode.val = preSum % 10;
        if (preSum / 10 > 0) {
            tmpNode.next = new ListNode(1);
        }

        return startNode;
    }

    private int getValue(ListNode node) {
        return null == node ? 0 : node.val;
    }

    private ListNode getNext(ListNode node) {
        return null == node ? null : node.next;
    }


}

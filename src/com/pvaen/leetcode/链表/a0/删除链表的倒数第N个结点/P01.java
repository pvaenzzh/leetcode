package com.pvaen.leetcode.链表.a0.删除链表的倒数第N个结点;

import com.pvaen.leetcode.链表.a0.ListNode;

import java.util.HashMap;

/**
 * 1 ms	37.8 MB	Java	2021/08/07 14:45
 */
public class P01 {

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});

        ListNode listNode = new P01().removeNthFromEnd(listNode1, 1);
        System.out.println(listNode);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode startNode = head;

        ListNode tmpNode = head;

        HashMap<Integer, ListNode> recordMap = new HashMap<>();
        int i = 0;
        while (null != tmpNode) {
            recordMap.put(i++, tmpNode);
            tmpNode = getNext(tmpNode);
        }

        ListNode preNode = recordMap.get(i - n - 1);
        ListNode nextNode = recordMap.get(i - n + 1);

        if (preNode == null) {
            return nextNode;
        } else {
            preNode.next = nextNode;
            return startNode;
        }
    }


    private ListNode getNext(ListNode node) {
        return null == node ? null : node.next;
    }

}

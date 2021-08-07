package com.pvaen.leetcode.链表.a0.合并两个有序链表;

import com.pvaen.leetcode.链表.a0.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 * 0 ms	37.8 MB	Java	2021/08/07 15:17
 */
public class P01 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildListNode(new int[]{1, 2, 2, 2, 3});
        ListNode listNode1 = ListNode.buildListNode(new int[]{1, 1, 1, 1, 1});

        ListNode listNode2 = new P01().mergeTwoLists(listNode, listNode1);
        System.out.println(listNode2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode l1TmpNode = l1;
        ListNode l2TmpNode = l2;

        ListNode resultStartNode;
        ListNode resultTmpNode;
        if (l2.val > l1.val) {
            resultStartNode = l1;
            l1TmpNode = getNext(l1);
            resultTmpNode = resultStartNode;
        } else {
            resultStartNode = l2;
            l2TmpNode = getNext(l2);
            resultTmpNode = resultStartNode;
        }

        while (l1TmpNode != null || l2TmpNode != null) {
            if (l1TmpNode == null) {
                resultTmpNode.next = l2TmpNode;
                resultTmpNode = resultTmpNode.next;
                l2TmpNode = getNext(l2TmpNode);
                continue;
            }
            if (l2TmpNode == null) {
                resultTmpNode.next = l1TmpNode;
                resultTmpNode = resultTmpNode.next;
                l1TmpNode = getNext(l1TmpNode);
                continue;
            }
            if (l2TmpNode.val > l1TmpNode.val) {
                resultTmpNode.next = l1TmpNode;
                resultTmpNode = resultTmpNode.next;
                l1TmpNode = getNext(l1TmpNode);
            } else {
                resultTmpNode.next = l2TmpNode;
                resultTmpNode = resultTmpNode.next;
                l2TmpNode = getNext(l2TmpNode);
            }
        }

        return resultStartNode;
    }

    private ListNode getNext(ListNode node) {
        return null == node ? null : node.next;
    }

}

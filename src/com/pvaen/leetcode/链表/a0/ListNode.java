package com.pvaen.leetcode.链表.a0;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildListNode(int[] p) {
        if (null == p || p.length == 0) return null;
        ListNode startNode = new ListNode(p[0]);
        ListNode tmpNode = startNode;
        for (int i = 1; i < p.length; i++) {
            tmpNode.next = new ListNode(p[i]);
            tmpNode = tmpNode.next;
        }
        return startNode;
    }

}

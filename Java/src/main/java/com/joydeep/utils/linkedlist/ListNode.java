package com.joydeep.utils.linkedlist;

public class ListNode {
     public Integer val;
     public ListNode next;
     public ListNode() {}
     public ListNode(int val) { this.val = val; this.next = null; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createListNodeFromInts(Integer... nums) {
        if (nums.length <= 0) {
            return new ListNode();
        }

        ListNode root = null;
        ListNode prev = null;

        for (Integer num : nums) {
            if (root == null) {
                root = new ListNode(num);
                prev = root;
                continue;
            }

            ListNode current = new ListNode(num);
            prev.next = current;
            prev = current;
        }
        return root;
    }

    public static String printListNodes(ListNode root) {
        StringBuilder sb = new StringBuilder();
        while (root != null) {
            sb.append(root.val+" -> ");
            root = root.next;
        }
        return sb.toString();
    }
}
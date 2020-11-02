package com.joydeep.solutions;

import com.joydeep.utils.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeKSortedLL {
    public static void main(String[] args) {
        List<ListNode> lis = new ArrayList<ListNode>(){{
            add(ListNode.createListNodeFromInts(1));
            add(ListNode.createListNodeFromInts(10));
//            add(ListNode.createListNodeFromInts(2, 6));
        }};

        System.out.println("Before Merging");
        lis.forEach(l -> System.out.println(ListNode.printListNodes(l)));
        System.out.println("After Merging");
        System.out.println(ListNode.printListNodes(mergeKLists(lis.toArray(new ListNode[0]))));

    }

    /**
     * The idea here is to merge two lists at every iteration
     * The number of lists will be halved at every iteration
     * Time Complexity O(Nlog2k)
     *
     * @param lists Lists to merge
     * @return single Listnode which is the head of the merge list
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        List<ListNode> og_list = new LinkedList<>();
        og_list.addAll(Arrays.asList(lists));
        List<ListNode> merged = new ArrayList<>();

        while (og_list.size() != 1) {
            int i = 1;
            while (i < og_list.size()) {
                merged.add(merge(og_list.get(i - 1), og_list.get(i)));
                og_list.remove(i - 1);
                og_list.remove(i - 1);
                i += 2;
            }

            og_list.addAll(merged);
            merged.clear();
        }
        return og_list.get(0);
    }

    public static ListNode merge(ListNode root1, ListNode root2) {

        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        ListNode root3 = null;
        ListNode last = null;

        while (root1 != null && root2 != null) {

            if (root3 == null) {
                if (root1.val < root2.val) {
                    ListNode next = root1.next;
                    root3 = root1;
                    root3.next = null;
                    last = root3;
                    root1 = next;
                }else {
                    ListNode next = root2.next;
                    root3 = root2;
                    root3.next = null;
                    last = root3;
                    root2 = next;
                }
                continue;
            }

            if (root1.val < root2.val) {
                ListNode next = root1.next;
                last.next = root1;
                last.next.next = null;
                last = last.next;
                root1 = next;
            }else {
                ListNode next = root2.next;
                last.next = root2;
                last.next.next = null;
                last = last.next;
                root2 = next;
            }
        }

        if (root1 == null) {
            last.next = root2;
        }else {
            last.next = root1;
        }
        return root3;
    }


}


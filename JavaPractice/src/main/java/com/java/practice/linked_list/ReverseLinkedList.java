package com.java.practice.linked_list;

import com.java.practice.algorithm.ListNode;

/**
 * TODO
 * <p>
 * Note: 链表反转
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/17 19:43
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
             ListNode next = cur.next;

             cur.next = prev;
             prev = cur;
             cur = next;
        }

        return prev;
    }
}

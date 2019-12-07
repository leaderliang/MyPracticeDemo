package com.java.practice.algorithm;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/07 18:36
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    /**
     * 链表节点的构造函数
     * 使用arr为参数，创建一个链表，当前的ListNode为链表头结点
     * @param arr
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}

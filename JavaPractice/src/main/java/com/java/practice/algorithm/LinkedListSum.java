package com.java.practice.algorithm;

/**
 * 链表求和
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/07 18:26
 */
public class LinkedListSum {

    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode preListNode = new ListNode(0);
        ListNode nowListNode = new ListNode(0);
        ListNode resultListNode = null;
        int val = 0;// 当前位置的数
        int add = 0;// 进位
        while (l1 != null || l2 != null) {
            //该位的数值
            val = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add) % 10;
            //对下一位产生的进位
            add = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add) / 10;
            l1 = l1 == null ? l1 : l1.next;//判断l1是否往下移动
            l2 = l2 == null ? l2 : l2.next;//判断l2是否往下移动
            //nowListNode和nowListNode用来产生一个新的链表
            nowListNode.val = val;
            if (resultListNode == null) {
                resultListNode = nowListNode;
            }
            preListNode = nowListNode;
            nowListNode = new ListNode(0);
            preListNode.next = nowListNode;
        }
        //最后还要多来一次判断，因为有一种可能，两个链表一样长，最后一位又向上进了一位
        val = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add) % 10;
        add = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add) / 10;
        nowListNode.val = val;
        //如果最后一位又向上进了一位，新的最后一位不为0，应该保留，否则就为0，应当舍弃
        if (nowListNode.val == 0) {
            preListNode.next = null;
        }
        return resultListNode;
    }

}

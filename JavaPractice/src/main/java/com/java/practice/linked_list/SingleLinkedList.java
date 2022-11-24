package com.java.practice.linked_list;


/**
 * TODO
 * <p>
 * Note: 快慢指针找单链表中间值
 *
 * 给定一个头节点为head的非空单链表，返回链表的中间结点，如果有两个中间结点,剩返回第二个中同结点
 * 当链表元素个数为奇数时，只有一个中间值
 * 当链表元素个数为偶数时，有两个中间值，取后值
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/24 19:28
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        initNode();
    }

    private static void initNode() {
        Node a = new Node("1");
        Node b = new Node("2");
        Node c = new Node("3");
        Node d = new Node("4");
        Node e = new Node("5");
        Node f = new Node("6");
        Node g = new Node("7");
//        Node h = new Node("8");
        // 建立链接，成为单链表
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
//        g.next = h;

        Node middle = getMiddleValue(a);
        System.out.println("中间节点为 " + middle.value);

        Node pre = getMiddlePreValue(a);
        System.out.println("中间节点的前一个为 " + pre.value);
    }

    private static Node getMiddleValue(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            System.out.println("\n快指针 " + fast);
            System.out.println("\n慢指针 " + slow);
        }
        return slow;
    }

    /**
     * 找中间节点的前一个节点
     * 奇数/偶数
     * @param head
     * @return
     */
    private static Node getMiddlePreValue(Node head) {
        Node fast = head;
        Node slow = head;
        int count = 0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if(fast != null){
                slow = slow.next;
            }
            System.out.println("\n快指针 " + fast);
            System.out.println("\n慢指针 " + slow);
        }
        return slow;
    }


}





package com.hang.practice.getoffer;

import com.hang.practice.ListNode;

/**
 * @author: hangshuo
 * @date: 2021/12/22 14:17
 * @Description:
 */

public class offer06_reverselist {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head1.next=head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

//        System.out.println(reverse(head1));

//        System.out.println(reverse2(head1));

//        System.out.println(reverse3(head1));

        System.out.println(reverse4(head1));

    }
    // 方式一
    public static ListNode reverse(ListNode root){
        if (root.getNext()==null){
            return root;
        }

        ListNode newList = reverse(root.getNext());
        root.next.next = root;
        root.next = null;
        return newList;
    }
    // 方式二
    public static ListNode reverse2(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // 方法三
    public static ListNode reverse3(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }

    public static ListNode reverse4(ListNode root){
        if (root.getNext() == null){
            return root;
        }

        ListNode newlist = reverse4(root.getNext());
        root.next.next = root;
        root.next = null;

        return newlist;

    }

    
}

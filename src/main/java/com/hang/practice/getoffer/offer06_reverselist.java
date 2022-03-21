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

        System.out.println(reverse2(head1));
    }

    public static ListNode reverse(ListNode root){
        if (root.getNext()==null){
            return root;
        }

        ListNode newList = reverse(root.getNext());
        root.next.next = root;
        root.next = null;
        return newList;
    }

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

    
}

package com.hang.practice.algorithm;

import com.hang.practice.ListNode;

/**
 * @author: hangshuo
 * @date: 2021/12/14 18:41
 * @Description:
 */

public class towNumberAdded {
    public static ListNode addTwoNumbers(ListNode l1 , ListNode l2){
        ListNode head = null , tail = null;
        int carry = 0;
        while (l1!= null || l2!= null){
            int n1 = l1!=null ? l1.getVal() : 0;
            int n2 = l2!= null ? l2.getVal() : 0;

            int sum = n1 + n2 + carry;
            if (head==null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.setNext(new ListNode(sum % 10 ));
                tail = tail.getNext();
            }
            carry = sum / 10;
            if (l1!=null) {
                l1 = l1.getNext();
            }
            if (l2 != null){
                l2 = l2.getNext();
            }
        }

        if (carry>0){
            tail.setNext(new ListNode(carry));
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);


        l1.setNext(l2);
        l2.setNext(l3);

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(7);
        ListNode l6 = new ListNode(8);

        l4.setNext(l5);
        l5.setNext(l6);

        ListNode listNode = addTwoNumbers(l1, l4);
        System.out.println(listNode);
    }
}

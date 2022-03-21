package com.hang.listNode;

/**
 * @author: hangshuo
 * @date: 2021/10/02 14:53
 * @Description:
 */

public class ListNodeTest {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode l3 = new ListNode();
        ListNode l4 = new ListNode();

        l1.setVal(1);
        l2.setVal(2);
        l3.setVal(3);
        l4.setVal(4);

        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);

        traverse1(l1);
    }
    public static void traverse(ListNode head){
        for (ListNode p = head;p!=null;p=p.next){
            if (p.next!=null){
                System.out.print(p.val+"-");
            }else {
                System.out.println(p.val);
            }
        }
    }

    public static void traverse1 (ListNode head){


        if (head.next!=null)
            traverse1(head.next);
        System.out.println(head.val);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
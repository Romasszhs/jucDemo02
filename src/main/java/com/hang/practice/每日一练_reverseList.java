package com.hang.practice;


/**
 * @author: hangshuo
 * @date: 2021/10/15 15:27
 * @Description:
 */
/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 每日一练_reverseList {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1 ; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode nex;

        for (int i = left; i < right; i++) {
            nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        /*
        * 操作步骤：
            先将 curr 的下一个节点记录为 next；
            执行操作 ①：把 curr 的下一个节点指向 next 的下一个节点；
            执行操作 ②：把 next 的下一个节点指向 pre 的下一个节点；
            执行操作 ③：把 pre 的下一个节点指向 next。
        * */

        return dummy.next;
    }

    public static ListNode reversedListNode(ListNode head){
        if (/*head==null ||*/ head.next== null){
            return head;
        }

        ListNode newHead = reversedListNode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reversedListNode2(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr !=null){
            ListNode nxt = curr.next;
            curr.next = prev;// 翻转当前节点的箭头
            prev = curr; // 三人行
            curr = nxt; // 三人行
        }
        return prev;
    }

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

        //ListNode listNode = reverseBetween(head1, 1, 4);
        //System.out.println(listNode);

        //System.out.println(reversedListNode(head1));

        System.out.println(reversedListNode2(head1));
    }
}

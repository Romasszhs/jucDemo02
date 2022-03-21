package com.hang.practice;

import lombok.*;

/**
 * @author: hangshuo
 * @date: 2021/10/16 11:29
 * @Description:
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

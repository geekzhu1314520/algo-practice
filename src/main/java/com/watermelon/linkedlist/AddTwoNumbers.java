package com.watermelon.linkedlist;

/**
 * <h1>AddTwoNumbers</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/11
 */
public class AddTwoNumbers {

    /**
     * 将两个链表表示的数字相加
     * 例如：2->4->3 + 5->6->4 表示 342 + 465 = 807，返回 7->0->8
     *
     * @param head1 第一个链表的头节点
     * @param head2 第二个链表的头节点
     * @return 相加后的结果链表
     */
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        // 用于存储进位
        int carry = 0;

        // 当两个链表都未遍历完或还有进位时继续循环
        while (head1 != null || head2 != null || carry != 0) {
            // 初始化本位和为进位值
            int sum = carry;

            // 如果第一个链表未遍历完，加上其值并移动指针
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }

            // 如果第二个链表未遍历完，加上其值并移动指针
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }

            // 计算进位和本位数
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int x) {
            val = x;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
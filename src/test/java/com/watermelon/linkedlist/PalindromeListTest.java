package com.watermelon.linkedlist;

import com.watermelon.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author zhujiashuai
 * @date: 2024/4/4 16:12
 * @description:
 */
public class PalindromeListTest extends UnitTestBase {

    @Test
    public void testIsPalindrome_case1() {
        PalindromeList.ListNode node1 = new PalindromeList.ListNode(1, null);
        PalindromeList palindromeList = new PalindromeList();
        assertTrue(palindromeList.isPalindrome(node1));
    }

    @Test
    public void testIsPalindrome_case2() {
        PalindromeList.ListNode node1 = new PalindromeList.ListNode(1, null);
        PalindromeList.ListNode node2 = new PalindromeList.ListNode(2, node1);
        PalindromeList palindromeList = new PalindromeList();
        assertFalse(palindromeList.isPalindrome(node2));
    }

    @Test
    public void testIsPalindrome_case3() {
        PalindromeList.ListNode node1 = new PalindromeList.ListNode(1, null);
        PalindromeList.ListNode node2 = new PalindromeList.ListNode(2, node1);
        PalindromeList.ListNode node3 = new PalindromeList.ListNode(1, node2);
        PalindromeList palindromeList = new PalindromeList();
        assertTrue(palindromeList.isPalindrome(node3));
    }

    @Test
    public void testIsPalindrome_case4() {
        PalindromeList.ListNode node1 = new PalindromeList.ListNode(1, null);
        PalindromeList.ListNode node2 = new PalindromeList.ListNode(2, node1);
        PalindromeList.ListNode node3 = new PalindromeList.ListNode(2, node2);
        PalindromeList.ListNode node4 = new PalindromeList.ListNode(1, node3);
        PalindromeList palindromeList = new PalindromeList();
        assertTrue(palindromeList.isPalindrome(node4));
    }

}

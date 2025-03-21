package com.watermelon.stack;

import com.watermelon.UnitTestBase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhujiashuai
 * @date: 2024/4/7 21:35
 * @description:
 */
public class ValidParenthesesTest extends UnitTestBase {

    @Test
    public void testIsValid_case1() {
        String s = "()";
        ValidParentheses validParentheses = new ValidParentheses();
        Assert.assertTrue(validParentheses.isValid(s));
    }

    @Test
    public void testIsValid_case2() {
        String s = "()[]{}";
        ValidParentheses validParentheses = new ValidParentheses();
        Assert.assertTrue(validParentheses.isValid(s));
    }

    @Test
    public void testIsValid_case3() {
        String s = "(]";
        ValidParentheses validParentheses = new ValidParentheses();
        Assert.assertFalse(validParentheses.isValid(s));
    }

}

package com.watermelon.stack;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhujiashuai
 * @date: 2024/4/7 22:22
 * @description:
 */
public class MinStackTest extends UnitTestBase {

    @Test
    public void testMinStack() {
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        assertThat(minStack.getMin(), Is.is(-3));
//        assertThat(minStack.pop(), Is.is(-3));
//        assertThat(minStack.top(), Is.is(0));
//        assertThat(minStack.getMin(), Is.is(-2));

//        MinStackV1 minStack = new MinStackV1();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        assertThat(minStack.getMin(), Is.is(-3));
//        assertThat(minStack.pop(), Is.is(-3));
//        assertThat(minStack.top(), Is.is(0));
//        assertThat(minStack.getMin(), Is.is(-2));

//        MinStackV2 minStack = new MinStackV2();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        assertThat(minStack.getMin(), Is.is(-3));
//        assertThat(minStack.pop(), Is.is(-3));
//        assertThat(minStack.top(), Is.is(0));
//        assertThat(minStack.getMin(), Is.is(-2));

//        MinStackV3 minStack = new MinStackV3();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        assertThat(minStack.getMin(), Is.is(-3));
//        minStack.pop();
//        assertThat(minStack.top(), Is.is(0));
//        assertThat(minStack.getMin(), Is.is(-2));

        MinStackV4 minStack = new MinStackV4();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertThat(minStack.getMin(), Is.is(-3));
        minStack.pop();
        assertThat(minStack.top(), Is.is(0));
        assertThat(minStack.getMin(), Is.is(-2));

    }

}

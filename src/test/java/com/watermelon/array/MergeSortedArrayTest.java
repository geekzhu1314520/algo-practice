package com.watermelon.array;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhujiashuai
 * @date: 2024/2/16 13:19
 * @description:
 */
public class MergeSortedArrayTest extends UnitTestBase {

    @Test
    public void merge_case1() {
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[] {2, 5, 6};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        assertThat(nums1, Is.is(new int[]{1,2,2,3,5,6}));
    }

    @Test
    public void merge_case2() {
        int[] nums1 = new int[] {1};
        int[] nums2 = new int[] {};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, 1, nums2, 0);
        assertThat(nums1, Is.is(new int[]{1}));
    }

    @Test
    public void merge_case3() {
        int[] nums1 = new int[] {0};
        int[] nums2 = new int[] {1};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, 0, nums2, 1);
        assertThat(nums1, Is.is(new int[]{1}));
    }

    @Test
    public void merge_case4() {
        int[] nums1 = new int[] {1,2,4,5,6,0};
        int[] nums2 = new int[] {3};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, 5, nums2, 1);
        assertThat(nums1, Is.is(new int[]{1,2,3,4,5,6}));
    }

}

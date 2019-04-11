package com.cheeryhu.leetcode;

import java.util.Arrays;

public class Test88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        Test88 t = new Test88();
        t.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int k = m, q = 0; k < m + n; k++, q++) {
            nums1[k] = nums2[q];
        }
        sort(nums1, 0, m + n - 1);

    }

    private void doMerge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (k = 0; k < temp.length; k++) {
            nums[low + k] = temp[k];
        }

    }

    private void sort(int[] nums, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        doMerge(nums, low, mid, high);
    }


}

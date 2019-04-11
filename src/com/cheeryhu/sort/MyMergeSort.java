package com.cheeryhu.sort;

import java.util.Arrays;

public class MyMergeSort {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 8, 4, 5};
        MyMergeSort myMergeSort = new MyMergeSort();
        myMergeSort.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void merge(int[] nums, int low, int mid, int high) {
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
            nums[k + low] = temp[k];
        }

    }

    private void sort(int[] nums, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }
}

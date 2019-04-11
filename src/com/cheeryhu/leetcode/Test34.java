package com.cheeryhu.leetcode;

import java.util.Arrays;

public class Test34 {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
        Test34 t = new Test34();
        System.out.println(Arrays.toString(t.searchRange(nums, target)));

    }

    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, 0, nums.length - 1, target);
        int last = findLast(nums, 0, nums.length - 1, target);
        return new int[]{first, last};

    }

    private int findFirst(int[] nums, int low, int high, int value) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (value < nums[mid]) {
                high = mid - 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != value) {
                    return mid;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private int findLast(int[] nums, int low, int high, int value) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (value < nums[mid]) {
                high = mid - 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == high || nums[mid + 1] != value) {
                    return mid;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}

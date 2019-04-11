package com.cheeryhu.sort;

/**
 * 数组中第k大的数
 */
public class MyQuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,8,4,5};
        int K = 1;
        MyQuickSort m = new MyQuickSort();
        System.out.print(m.getNumInArray(nums,K));
    }

    public int getNumInArray(int[] nums,int K){
        return realGetNumInArray(nums,nums.length+1-K);
    }

    private int realGetNumInArray(int[] nums,int K){
        if(nums == null || nums.length == 0 || nums.length < K){
            return -1;
        }
        int p = doGetNumInArray(nums,0,nums.length-1);
        while(p != K-1){
            if(p < K-1){
                p = doGetNumInArray(nums,p+1,nums.length-1);
            }else{
                p = doGetNumInArray(nums,0,p-1);
            }
        }
        return nums[p];
    }

    private int doGetNumInArray(int[] nums,int low,int high){
        int i=low,j=high+1;
        int pivot=nums[low];
        while(true){
            while(pivot<nums[--j] && j!=low);
            while(nums[++i]<pivot && i!=high);
            if(i>=j)break;
            swap(nums,i,j);
        }
        swap(nums,low,j);
        return j;
    }

    private void swap(int[] nums, int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}

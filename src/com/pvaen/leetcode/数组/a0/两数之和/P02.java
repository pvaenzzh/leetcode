package com.pvaen.leetcode.数组.a0.两数之和;


import java.util.HashMap;

/**
 * 利用hash
 * 	2 ms	38.7 MB	Java	2021/07/30 22:33
 */
public class P02 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> objectObjectHashMap = new HashMap<>();

        int needNum;
        for (int i = 0; i < nums.length; i++) {
            needNum = target - nums[i];
            if (objectObjectHashMap.containsKey(needNum)){
                return new int[]{i, objectObjectHashMap.get(needNum)};
            }
            objectObjectHashMap.put(nums[i], i);
        }

        return null;
    }

}

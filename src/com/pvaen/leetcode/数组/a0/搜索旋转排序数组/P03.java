package com.pvaen.leetcode.数组.a0.搜索旋转排序数组;

public class P03 {

//    C++
//    public:
//    int search(vector<int>& nums, int target) {
//        int lo = 0, hi = nums.size() - 1;
//        while (lo < hi) {
//            int mid = (lo + hi) / 2;
//            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
//                lo = mid + 1;
//            else
//                hi = mid;
//        }
//        return lo == hi && nums[lo] == target ? lo : -1;
//    }
//};

    public static void main(String[] args) {
        System.out.println(new P03().search(new int[]{1, 2}, 2));
    }

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo == hi && nums[lo] == target ? lo : -1;
    }


}

package com.pvaen.leetcode.study;

public class 二分 {

//    int binarySearch(int[] nums, int target) {
//        int left = 0, right = ...;
//        while(...) {
//            int mid = (right + left) / 2;
//            if (nums[mid] == target) {
//            ...
//            } else if (nums[mid] < target) {
//                left = ...
//            } else if (nums[mid] > target) {
//                right = ...
//            }
//        }
//        return ...;
//    }

    public static void main(String[] args) {
        System.out.println(new 二分().binarySearchR02(new int[]{1, 3, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 10}, 1));
    }

    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    //不能使用
    int binarySearchL(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;//如果使用while <= 不方便结束
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (nums[right + 1] == target) return right;
        return -1;
    }

    int binarySearchL01(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right + left) / 2;
            if (target < nums[mid]) {
                right = mid;
            } else if (nums[mid] == target) {
                right = mid;//如果使用while <= 不方便结束
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left != nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    //不能使用
    int binarySearchR01(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }

    int binarySearchR02(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) return -1;
        return left == right && nums[left - 1] == target ? left - 1 : -1;

    }


}

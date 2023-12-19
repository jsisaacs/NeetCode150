package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        // runtime: O(n)
        while (l <= r) {
            char lC = s.charAt(l);
            char rC = s.charAt(r);
            if (!Character.isAlphabetic(lC) && !Character.isDigit(lC)) {
                l++;
                continue;
            }
            if (!Character.isAlphabetic(rC) && !Character.isDigit(rC)) {
                r--;
                continue;
            }
            if (Character.toLowerCase(lC) == Character.toLowerCase(rC)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Runtime: O(n), Space O(1)
     * @param nums 1-indexed sorted in non-decreasing order
     * @param t target, there is exactly one solution
     * @return indices of the 2 numbers that add up to t (1-indexed)
     */
    public static int[] twoSumSortedInput(int[] nums, int t) {
        int l = 0;
        int r = nums.length - 1;
        int[] answer = new int[2];
        while (l <= r) {
            int numL = nums[l];
            int numR = nums[r];
            if (numL + numR == t) {
                //answer is 1-indexed
                answer[0] = l + 1;
                answer[1] = r + 1;
                break;
            }
            if (numL + numR > t) {
                r--;
                continue;
            }
            l++;
        }
        return answer;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                if (threeSum > 0) {
                    r--;
                } else if (threeSum < 0) {
                    l++;
                } else {
                    answer.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                }
            }
        }
        return answer;
    }

    /**
     * 11. Container With Most Water
     * @param height elements correspond to vertical lines
     * @return max water
     * @implNote time is O(n), space is O(1)
     */
    public static int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int maxArea = Integer.MIN_VALUE;
        while (l < r) {
            int minH = Math.min(height[l], height[r]);
            int w = r - l;
            maxArea = Math.max(maxArea, minH * w);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}

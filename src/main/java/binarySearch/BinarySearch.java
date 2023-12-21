package binarySearch;

public class BinarySearch {
    /**
     * 704. Binary Search
     * @param nums int array sorted in ascending order
     * @param target int
     * @return the index of target if it exists in nums, otherwise -1
     * @implNote time is O(logn), space is O(1)
     */
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}

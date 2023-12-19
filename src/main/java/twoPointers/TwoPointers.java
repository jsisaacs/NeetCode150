package twoPointers;

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
}

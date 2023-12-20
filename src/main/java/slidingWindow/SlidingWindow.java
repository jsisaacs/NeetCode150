package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {
    /**
     * 121. Best Time to Buy and Sell Stock
     * @param prices stock value, where prices[i] is the price on the ith day
     * @return max profit across 2 distinct days, or if no profit 0
     * @implNote time is O(n), space is O(1)
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int l = 0;
        int r = 1;
        int maxProfit = Integer.MIN_VALUE;
        while (l < n - 1 && r < n) {
            maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            if (prices[r] < prices[l]) {
                l = r;
                r++;
            } else {
                r++;
            }
        }
        return Math.max(maxProfit, 0);
    }

    /**
     * 3. Longest Substring Without Repeating Characters
     * @param s input string, consists of English letters, digits, symbols, and spaces
     * @return length of the longest substring without repeating chars
     * @implNote time is O(n), space is O(n)
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;
        Set<Character> substringSet = new HashSet<>();
        int l = 0;
        int  longestSubstring = 0;
        for (int r = 0; r < n; r++) {
            char cR = s.charAt(r);
            while (substringSet.contains(cR)) {
                char cL = s.charAt(l);
                substringSet.remove(cL);
                l++;
            }
            substringSet.add(cR);
            longestSubstring = Math.max(longestSubstring, r - l + 1);
        }
        return longestSubstring;
    }

    /**
     * 424. Longest Repeating Character Replacement
     * @param s input string, only uppercase English letters
     * @param k max number of char swaps
     * @return length of the longest substring containing the same
     * letter you can get via swaps
     */
    public static int characterReplacement(String s, int k) {
        return 0;
    }
}

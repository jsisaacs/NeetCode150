package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {
    /**
     * 121. Best Time to Buy and Sell Stock
     *
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
            }
            r++;
        }
        return Math.max(maxProfit, 0);
    }

    /**
     * 3. Longest Substring Without Repeating Characters
     *
     * @param s input string, consists of English letters, digits, symbols, and spaces
     * @return length of the longest substring without repeating chars
     * @implNote time is O(n), space is O(n)
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;
        Set<Character> substringSet = new HashSet<>();
        int l = 0;
        int longestSubstring = 0;
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
     *
     * @param s input string, only uppercase English letters
     * @param k max number of char swaps
     * @return length of the longest substring containing the same
     * letter you can get via swaps
     * @implNote time is O(n), space is O(1) since m = 26
     */
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        int longestRepeating = 0;
        int maxFreq = 0;
        for (int r = 0; r < n; r++) {
            char cR = s.charAt(r);
            window.merge(cR, 1, Integer::sum);
            maxFreq = Math.max(maxFreq, window.get(cR));
            while ((r - l + 1) - maxFreq > k) {
                char cL = s.charAt(l);
                window.compute(cL, (key, val) -> val != null ? val - 1 : null);
                l++;
            }
            longestRepeating = Math.max(longestRepeating, r - l + 1);
        }
        return longestRepeating;
    }

    /**
     * 567. Permutation in String
     *
     * @param s1 consists of lowercase English letters
     * @param s2 consists of lowercase English letters
     * @return true if s2 contains a permutation of s1, otherwise false
     * @implNote time is O(n), space is O(m), where m = length of s1
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        Map<Character, Integer> s1Freq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Freq.merge(c, 1, Integer::sum);
        }
        for (int r = 0; r < s2.length(); r++) {
            char cR = s2.charAt(r);
            windowFreq.merge(cR, 1, Integer::sum);
            if (r >= s1.length()) {
                char l = s2.charAt(r - s1.length());
                windowFreq.computeIfPresent(l, (k, v) -> v != 1 ? v - 1 : null);
            }
            if (windowFreq.equals(s1Freq)) {
                return true;
            }
        }
        return false;
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import slidingWindow.SlidingWindow;

public class SlidingWindowTests {
    @Test
    void maxProfitTest() {
        int[] prices = {7,1,5,3,6,4};
        int profit = SlidingWindow.maxProfit(prices);
        int expected = 5;
        Assertions.assertEquals(expected, profit);
    }

    @Test
    void lengthOfLongestSubstringTest() {
        String s = "pwwkew";
        int len = SlidingWindow.lengthOfLongestSubstring(s);
        int expected = 3;
        Assertions.assertEquals(expected, len);
    }

    @Test
    void characterReplacementTest() {
        String s = "ABAB";
        int k = 2;
        int output = SlidingWindow.characterReplacement(s, k);
        int expected = 4;
        Assertions.assertEquals(expected, output);
    }

    @Test
    void checkInclusionTest() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean answer = SlidingWindow.checkInclusion(s1, s2);
        Assertions.assertTrue(answer);

        s1 = "ab";
        s2 = "eidboaoo";
        answer = SlidingWindow.checkInclusion(s1, s2);
        Assertions.assertFalse(answer);
    }
}

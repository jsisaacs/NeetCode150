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
}

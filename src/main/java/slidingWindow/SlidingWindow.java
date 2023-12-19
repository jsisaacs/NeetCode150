package slidingWindow;

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
}

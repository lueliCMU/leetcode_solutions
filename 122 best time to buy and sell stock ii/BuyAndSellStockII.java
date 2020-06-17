public class BuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int start = 0;
        int end = 0;
        int res = 0;
        while (end < prices.length - 1) {
            if (prices[end] < prices[end + 1]) {
                end++;
            } else {
                res += prices[end] - prices[start];
                end++;
                start = end;
            }
        }
        res += prices[end] - prices[start];
        return res;
    }
}
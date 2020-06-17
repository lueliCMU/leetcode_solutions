
public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = prices[0];
        int min = prices[0];
        int res = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
                max = price;
            }
            if (price > max) {
                max = price;
            }
            res = Math.max(res, max - min);
        }
        return res;
    }
}
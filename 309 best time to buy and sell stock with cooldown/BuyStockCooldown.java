
public class BuyStockCooldown {
    /**
     * There are three states: s0, s1, s2
     * if I rest at s0, the state remains at s0
     * if I buy at s0, the state goes to s1
     * if I rest at s1, the state remains at s1
     * if I sell at s1, the state goes to s2
     * if I rest at s2, the state goes to s0
     * 
     * we use three arrays:
     * s0[]: s0[i] represents at day i, if we end with s0, the max profit
     * s1[]: s1[i] represents at day i, if we end with s1, the max profit
     * s2[]: s2[i] represents at day i, if we end with s2, the max profit
     * 
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] s0 = new int[n];
        int[] s1 = new int[n];
        int[] s2 = new int[n];
        
        s0[0] = 0;   // at start don't have stock just rest
        s1[0] = -prices[0]; // after buy, should have -prices[0] profit
        s2[0] = Integer.MIN_VALUE; // impossible, so set the min value of integer
        
        for (int i = 1; i < prices.length; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);  // could be rest at s0 or rest at s2
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]); // could be buy at s0 or rest at s1
            s2[i] = s1[i - 1] + prices[i]; // could be sell at s2
        }
        return Math.max(s0[n - 1], s2[n - 1]); // we can only end with s0 and s2.
    }
}
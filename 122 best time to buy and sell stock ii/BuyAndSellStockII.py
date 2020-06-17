class BuyAndSellStockII(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        start = 0
        end = 0
        res = 0
        while end < len(prices) - 1:
            if (prices[end] <= prices[end + 1]):
                end += 1
            else:
                res += prices[end] - prices[start]
                end += 1
                start = end
        res += prices[end] - prices[start]
        return res
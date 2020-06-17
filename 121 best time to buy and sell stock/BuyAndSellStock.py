class BuyAndSellStock(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        maxPrice = prices[0]
        minPrice = prices[0]
        res = 0
        
        for i in range(len(prices)):
            if prices[i] > maxPrice:
                maxPrice = prices[i]
            
            if prices[i] < minPrice:
                minPrice = prices[i]
                maxPrice = prices[i]
            
            
            res = max(res, maxPrice - minPrice)
        
        return res
        
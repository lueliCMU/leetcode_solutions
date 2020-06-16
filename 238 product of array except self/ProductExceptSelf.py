class ProductExceptSelf(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        res = [1] * n
        acc_product = nums[n - 1]
        
        for i in range(n - 2, -1, -1):
            res[i] = acc_product
            acc_product *= nums[i]
        
        acc_product = 1
        for i in range(n):
            res[i] = acc_product * res[i]
            acc_product *= nums[i]
        
        return res
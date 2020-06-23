class SubarraySumEqualsK(object):
    def subarraySum1(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pre_sums = {}
        cur_sum = 0
        res = 0
        for num in nums:
            if cur_sum in pre_sums:
                pre_sums[cur_sum] += 1
            else:
                pre_sums[cur_sum] = 1
            
            cur_sum += num
            
            if cur_sum - k in pre_sums:
                res += pre_sums[cur_sum - k]
        
        return res

    def subarraySum2(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pre_sums = {}
        cur_sum = 0
        res = 0
        for num in nums:
            pre_sums[cur_sum] = pre_sums.get(cur_sum, 0) + 1
            cur_sum += num
            res += pre_sums.get(cur_sum - k, 0)
        
        return res
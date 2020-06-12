class Solution(object):
    # Two pointers: Space O(1) Time O(n)
    def trap1(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        n = len(height)
        if n <= 2:
            return 0
        left_max = height[0]
        right_max = height[n - 1]
        
        left = 0
        right = n - 1
        
        res = 0
        
        while (left < right):
            if height[left] < height[right]:
                if left_max < height[left]:
                    left_max = height[left]
                elif left_max > height[left]:
                    res += left_max - height[left]
                left += 1
            else:
                if right_max < height[right]:
                    right_max = height[right]
                elif right_max > height[right]:
                    res += right_max - height[right]
                right -= 1
        
        return res
    
    # Dynamic programming: Space O(n) Time O(n)
    def trap2(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        n = len(height)
        if n <= 2:
            return 0
        left_max = [0] * n
        right_max = [0] * n
        left_max[0] = height[0]
        right_max[n - 1] = height[n - 1]
        
        for i in range(1, n - 1):
            left_max[i] = max(left_max[i - 1], height[i])
        
        for i in range(n - 2, 0, -1):
            right_max[i] = max(right_max[i + 1], height[i])
        
        res = 0
        
        for i in range(1, n - 1):
            water = min(left_max[i], right_max[i]) - height[i]
            if water < 0:
                continue
            res += water
        
        return res
    
    # Monolithic Stack: Time O(n) Space O(n)
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        stack, res = [], 0
        
        for i, v in enumerate(height):
            while len(stack) > 0 and height[stack[-1]] < v:
                cur = height[stack.pop()]
                if len(stack) == 0:
                    break
                res += (min(height[stack[-1]], v) - cur) * (i - stack[-1] - 1)
            
            stack.append(i)      
        
        return res
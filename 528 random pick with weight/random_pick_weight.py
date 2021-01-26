import random

class random_pick_weight(object):

    def __init__(self, w):
        """
        :type w: List[int]
        """
        self.w = w
        self.n = len(w)
        for i in range(1, self.n):
            w[i] += w[i - 1]
        self.s = w[-1]

    def pickIndex(self):
        """
        :rtype: int
        """
        idx = random.randint(1, self.s)
        left, right = 0, self.n - 1
        while left < right:
            mid = left + (right - left) / 2
            if idx == self.w[mid]:
                return mid
            if idx < self.w[mid]:
                right = mid
            else:
                left = mid + 1
        return left
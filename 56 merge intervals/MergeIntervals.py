class MergeIntervals(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        if not intervals:
            return []
        res = []
        start = []
        end = []
        n = len(intervals)
        for i in range(n):
            start.append(intervals[i][0])
            end.append(intervals[i][1])
        
        start.sort()
        end.sort()
        s = 0
        i = 0
        while i < n - 1:
            if end[i] >= start[i + 1]:
                i += 1
            else:
                res.append([start[s], end[i]])
                i += 1
                s = i
        res.append([start[s], end[i]])
        
        return res
        
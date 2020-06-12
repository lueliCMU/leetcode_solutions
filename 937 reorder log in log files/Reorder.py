class Solution(object):
    def reorderLogFiles(self, logs):
        """
        :type logs: List[str]
        :rtype: List[str]
        """
        digits = []
        letters = []
        
        for log in logs:
            if log.split()[1].isdigit():
                digits.append(log)
            else:
                letters.append(log)
        

        # Has to sort by identifier first, because we need to make sure
        # we sort by log when logs don't tie
        letters.sort(key = lambda x : x.split()[0])  # sort by identifier when log ties
        letters.sort(key = lambda x : x.split()[1:]) # sort by log
        
        return letters + digits
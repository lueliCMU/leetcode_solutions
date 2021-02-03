import collections

class task_sceduler(object):
    def leastInterval1(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        task_counts = collections.Counter(tasks).values()
        Max_freq = max(task_counts)
        Max_freq_count = task_counts.count(Max_freq)
        return max(len(tasks), (Max_freq - 1) * (n + 1) + Max_freq_count)
    
    def leastInterval2(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        task_counts = collections.Counter(tasks).values()
        Max_freq = max(task_counts)
        Max_freq_count = task_counts.count(Max_freq)
        
        empty_slots = (n - Max_freq_count + 1) * (Max_freq - 1)
        available_tasks = len(tasks) - Max_freq *  Max_freq_count;
        
        idles = max(0, empty_slots - available_tasks);
        
        return len(tasks) + idles

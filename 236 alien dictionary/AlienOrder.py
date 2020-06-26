class AlienOrder(object):
    def alienOrder(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        adj = {}
        letters = [0 for i in range(26)]
        for word in words:
            for ch in word:
                key = ord(ch) - ord('a')
                letters[key] = 0
                adj[key] = set()
        
        for i in range(len(words) - 1):
            word1 = words[i]
            word2 = words[i + 1]
            idx = 0
            if len(word1) > len(word2) and word1.startswith(word2):
                return ""
            for j in range(min(len(word1), len(word2))):
                if (word1[j] != word2[j]):
                    key1 = ord(word1[j]) - ord('a')
                    key2 = ord(word2[j]) - ord('a')
                    count = letters[key2]
                    if key2 not in adj[key1]:
                        letters[key2] = count + 1
                        adj[key1].add(key2)
                    break
        
        queue = collections.deque()
        res = ''
        for i in range(26):
            if letters[i] == 0 and i in adj:
                queue.appendleft(i);
        while len(queue) > 0:
            cur = queue.pop()
            res += chr(cur + ord('a'))
            nextNodes = adj[cur]
            for nextNode in nextNodes:
                letters[nextNode] -= 1
                if letters[nextNode] == 0:
                    queue.appendleft(nextNode)
        
        if len(adj) != len(res):
            return ""
        return res
        
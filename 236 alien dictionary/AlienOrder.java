class AlienOrder {
    /**
     * Treat each character as a node and word list as a
     * relationship map.
     * 
     * Use topological sort to sort those characters.
     * 
     */
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                indegree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            
            if (cur.startsWith(next) && cur.length() > next.length()) {
                return "";
            }
            
            int k = 0;
            int j = 0;
            while (k < cur.length() && j < next.length()) {
                if (cur.charAt(k) != next.charAt(j)) {
                    break;
                }
                k++;
                j++;
            }
            if (k < cur.length() && j < next.length()) {
                char c1 = cur.charAt(k);
                char c2 = next.charAt(j);
                adj.putIfAbsent(c1, new ArrayList<>());
                adj.putIfAbsent(c2, new ArrayList<>());
                adj.get(c1).add(c2);
                indegree.put(c2, indegree.getOrDefault(c2, 0) + 1);
                indegree.put(c1, indegree.getOrDefault(c1, 0));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Deque<Character> queue = new LinkedList<>();
        
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.addLast(c);
            }
        }
        
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            sb.append(cur);
            List<Character> nextLetters = adj.get(cur);
            if (nextLetters == null) continue;
            for (char c : nextLetters) {
                indegree.put(c, indegree.get(c) - 1);
                if (indegree.get(c) == 0) {
                    queue.addLast(c);
                }
            }
        }
        
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
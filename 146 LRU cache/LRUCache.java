
class LRUCache {
    // a hashmap and a list
    // the last node represent the most recent node
    // the first node represent the least recent node
    int cap;
    MyNode head;
    Map<Integer, MyNode> map;
    public LRUCache(int capacity) {
        head = null;
        cap = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        MyNode node = map.get(key);
        deleteFromList(node);
        addToList(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            MyNode node = map.get(key);
            node.value = value;
            deleteFromList(node);
            addToList(node);
        } else {
            MyNode node = new MyNode(key, value);
            map.put(key, node);
            addToList(node);
        }
        if (map.size() > cap) {
            map.remove(head.prev.key);
            deleteFromList(head.prev);
            
        }
    }
    
    class MyNode {
        int key;
        int value;
        MyNode next;
        MyNode prev;
        
        public MyNode(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }
    
    private void deleteFromList(MyNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (head == node) {
            head = node.next;
        }
    }
    // add to the last node
    private void addToList(MyNode node) {
        if (head == null) {
            head = node;
            node.next = node;
            node.prev = node;
        } else {
            head.prev.next = node;
            node.prev = head.prev;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
}
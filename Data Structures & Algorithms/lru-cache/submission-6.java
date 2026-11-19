class LRUCache {

    public class Node{
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val =val;
            this.next = null;
            this.prev = null;
        }
    }

    Node first;
    Node last;
    int capacity;
    HashMap<Integer,Node> cache;

    public LRUCache(int capacity) {
        this.first = new Node(0,0);
        this.last = new Node(0,0);

        this.first.next = this.last;
        this.last.prev = this.first;
        this.capacity = capacity;
        cache = new HashMap<>();
        
    }

    private void insert(Node node){
        Node mru = this.last.prev;
        mru.next = node;
        node.next = this.last;
        node.prev = mru;
        this.last.prev = node;
        
    }
    private void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

   
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode = new Node(key,value);
        cache.put(key,newNode);
        insert(newNode);
        if(cache.size() > capacity){
            Node lru = this.first.next;
            remove(lru);
            cache.remove(lru.key);

        }


        
    }
}

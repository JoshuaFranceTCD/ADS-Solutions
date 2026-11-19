class LRUCache {

    private int capacity;
    private ArrayList<int[]> data;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
        
    }
    
    public int get(int key) {

         for(int i = 0; i < data.size(); i++){
            int[] entry = data.get(i);
            if(entry[0] == key){
                data.remove(i);
                data.add(entry);
                return entry[1];
            }
        }
        return - 1;


        
    }
    
    public void put(int key, int value) {

        for(int i = 0; i < data.size(); i++){
            int[] entry = data.get(i);
            if(entry[0] == key){
                data.remove(i);
                entry[1] = value;
                data.add(entry);
                return;
            }
        }


        if(data.size() == capacity){
            data.remove(0);
        }
        data.add(new int[]{key,value});     
    }
}

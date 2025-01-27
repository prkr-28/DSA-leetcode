class LRUCache {
    int cap=-1;
    Map<Integer,Integer>map;
    public LRUCache(int capacity) {
        cap=capacity;
        map=new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int val=map.get(key);
        map.remove(key);
        map.put(key,val);
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
        }
        if(map.size()==cap){
            int k;
            for(int i:map.keySet()){
                k=i;
                map.remove(k);
                break;
            }
        }
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
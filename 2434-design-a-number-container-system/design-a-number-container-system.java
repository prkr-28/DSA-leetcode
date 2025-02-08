class NumberContainers {
    Map<Integer,Integer>idxtonum;
    Map<Integer,TreeSet<Integer>>numtoidx;
    public NumberContainers() {
        idxtonum=new HashMap<>();
        numtoidx=new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(idxtonum.containsKey(index)){
            int prevnum=idxtonum.get(index);
            numtoidx.get(prevnum).remove(index);
            if(numtoidx.get(prevnum).isEmpty()){
                numtoidx.remove(prevnum);
            }
        }
        idxtonum.put(index,number);
        numtoidx.putIfAbsent(number,new TreeSet<>());
        numtoidx.get(number).add(index);
    }
    
    public int find(int number) {
        if(numtoidx.containsKey(number)){
            return numtoidx.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
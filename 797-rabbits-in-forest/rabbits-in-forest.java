class Solution {
    public int numRabbits(int[] answers) {
        int minrabbits=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i:answers){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()){
            int grpsize=i+1;
            int count=map.get(i);
            int totalgrp=(int)Math.ceil((double)count/grpsize);
            minrabbits+=totalgrp*grpsize;
        }
        return minrabbits;
    }
}
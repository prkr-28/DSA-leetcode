import java.util.*;
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer>map=new TreeMap<>();
        for(int[] arr:nums1){
            map.put(arr[0],map.getOrDefault(arr[0],0)+arr[1]);
        }
        for(int[] arr:nums2){
            map.put(arr[0],map.getOrDefault(arr[0],0)+arr[1]);
        }

        int[][] result=new int[map.size()][2];
        int idx=0;
        for(Map.Entry<Integer,Integer>pair:map.entrySet()){
            result[idx][0]=pair.getKey();
            result[idx][1]=pair.getValue();
            idx++;
        }
        return result;
    }
}
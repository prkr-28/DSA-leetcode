class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int[] arr=nums.clone();
        Arrays.sort(arr);
        int groupnum=0;
        Map<Integer,Integer>group=new HashMap<>();
        Map<Integer,LinkedList<Integer>>grouptolist=new HashMap<>();
        group.put(arr[0],groupnum);
        grouptolist.putIfAbsent(groupnum,new LinkedList<>());
        grouptolist.get(groupnum).add(arr[0]);
        for(int i=1;i<n;i++){
            if(Math.abs(arr[i]-arr[i-1])>limit){
                groupnum++;
            }
            group.put(arr[i], groupnum);
            grouptolist.putIfAbsent(groupnum, new LinkedList<>());
            grouptolist.get(groupnum).add(arr[i]);
        }
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            int num=nums[i];
            int g=group.get(num);
            result[i]=grouptolist.get(g).pollFirst();
        }
        return result;
    }
}
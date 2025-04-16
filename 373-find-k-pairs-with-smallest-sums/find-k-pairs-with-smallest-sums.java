class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1=nums1.length;
        int n2=nums2.length;
        List<List<Integer>>res=new ArrayList<>();
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        Set<String>set=new HashSet<>();
        int i=0;
        int j=0;
        pq.add(new int[]{nums1[i]+nums2[j],i,j});
        set.add(i+","+j);
        while(k-->0){
            int[] temp=pq.poll();
            int sum=temp[0];
            i=temp[1];
            j=temp[2];
            List<Integer>list=new ArrayList<>();
            list.add(nums1[i]);
            list.add(nums2[j]);
            res.add(list);
            if(i+1<n1){
                String key=(i+1)+","+j;
                if(!set.contains(key)){
                    pq.add(new int[]{nums1[i+1]+nums2[j],i+1,j});
                    set.add(key);
                }
            }
            if(j+1<n2){
                String key=i+","+(j+1);
                if(!set.contains(key)){
                    pq.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
                    set.add(key);
                }
            }
        }
        return res;
    }
}
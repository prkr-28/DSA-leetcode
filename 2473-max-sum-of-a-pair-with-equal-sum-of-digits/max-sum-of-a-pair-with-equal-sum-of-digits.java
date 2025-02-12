class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i:nums){
            int temp=sum(i);
            map.putIfAbsent(temp,new ArrayList<>());
            map.get(temp).add(i);
        }
        int maxsum=-1;
        for(List<Integer>arr:map.values()){
            if(arr.size()>=2){
                int firstmax=0;
                int secmax=0;
                for(int x:arr){
                    if(x>firstmax){
                        secmax=firstmax;
                        firstmax=x;
                    }
                    else if(x>secmax){
                        secmax=x;
                    }
                }
                maxsum=Math.max(maxsum,firstmax+secmax);
            }
        }
        return maxsum;
    }
    public int sum(int num){
        int sum=0;
        while(num>0){
            int rem=num%10;
            sum+=rem;
            num=num/10;
        }
        return sum;
    }
}
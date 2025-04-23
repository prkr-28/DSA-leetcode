class Solution {
    public int countLargestGroup(int n) {
        int maxsize=0;
        int count=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=1;i<=n;i++){
            int sum=finddigitsum(i);
            map.put(sum,map.getOrDefault(sum,0)+1);
            if(map.get(sum)==maxsize){
                count++;
            }
            else if(maxsize<map.get(sum)){
                maxsize=map.get(sum);
                count=1;
            }
        }
        return count;
    }

    public int finddigitsum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
}
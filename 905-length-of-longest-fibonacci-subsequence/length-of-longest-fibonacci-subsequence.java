class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer>set=new HashSet<>();
        for(int i:arr){
            set.add(i);
        }
        int n=arr.length;
        int maxicount=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int count=2;
                int num1=arr[i];
                int num2=arr[j];
                while(set.contains(num1+num2)){
                    int sum=num1+num2;
                    num1=num2;
                    num2=sum;
                    count++;
                }
                maxicount=Math.max(maxicount,count);
            }
        }
        return maxicount>2?maxicount:0;
    }
}
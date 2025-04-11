class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for(int i=low;i<=high;i++){
            int currnum=i;
            int c=0;
            while(currnum>0){
                c++;
                currnum=currnum/10;
            }
            if(c%2==1){
                continue;
            }

            currnum=i;
            int count=0;
            int a=0;
            int b=0;
            while(count < c/2){
                a+=currnum%10;
                currnum=currnum/10;
                count++;
            }
            while(count<c){
                b+=currnum%10;
                currnum=currnum/10;
                count++;
            }
            if(a==b){
                ans++;
            }

        }
        return ans;
    }
}
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int curr_un_cust=0;
        for(int i=0;i<minutes;i++){
            curr_un_cust+=customers[i]*grumpy[i];
        }
        int max_un_cust=curr_un_cust;
        int i=0;
        int j=minutes;
        while(j<customers.length){
            curr_un_cust+=customers[j]*grumpy[j];
            curr_un_cust-=customers[i]*grumpy[i];

            max_un_cust=Math.max(max_un_cust,curr_un_cust);
            i++;
            j++;
        }
        for(int k=0;k<customers.length;k++){
            max_un_cust+=customers[k]*(1-grumpy[k]);
        }
        return max_un_cust;
    }
}
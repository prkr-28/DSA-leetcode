class Solution {
    public int countOrders(int n) {
        long res=1;
        for(int i=2;i<=n;i++){
            res =res * (i * (2 * i - 1)) % 1000000007;
        }
        return (int)res;
    }
}
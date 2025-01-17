class Solution {
    public int minBitFlips(int start, int goal) {
        int temp=start^goal;
        return Integer.bitCount(temp);
    }
}
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xorNums1 = 0;
        int xorNums2 = 0;
        for (int num : nums1) {
            xorNums1 ^= num;
        }
        for (int num : nums2) {
            xorNums2 ^= num;
        }
        int result = 0;
        if (nums2.length % 2 != 0) {
            result ^= xorNums1;
        }
        if (nums1.length % 2 != 0) {
            result ^= xorNums2;
        }
        
        return result;
    }
}
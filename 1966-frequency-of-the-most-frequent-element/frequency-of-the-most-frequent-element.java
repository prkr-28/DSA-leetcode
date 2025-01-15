class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long currSum = 0; 
        int maxFreq = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {
            currSum += nums[right];
            if ((long) nums[right] * (right - left + 1) - currSum > k) {
                currSum -= nums[left]; // Shrink the window from the left
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;
    }
}
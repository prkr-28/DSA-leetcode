class Solution {
    public String triangleType(int[] nums) {
        int i = 0;
        int j = 1;
        int k = 2;
        if (nums[i] + nums[j] > nums[k] && nums[j] + nums[k] > nums[i] && nums[i] + nums[k] > nums[j]) {
            if (nums[i] == nums[j] && nums[j] == nums[k]) {
                return "equilateral";
            } else if (nums[i] == nums[j] || nums[j] == nums[k] || nums[i] == nums[k]) {
                return "isosceles";
            } else {
                return "scalene";
            }
        }
        return "none";
    }
}
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        
        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }

        for (int i = 0; i < (1 << n); i++) { // Loop from 0 to 2^n - 1
            if (!set.contains(i)) {
                return String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            }
        }
        return "";
    }
}
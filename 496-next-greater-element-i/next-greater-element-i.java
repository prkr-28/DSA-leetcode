class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>s=new Stack<>();
        int[] result=new int[nums1.length];
        int[] ans=new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            while(!s.isEmpty()&&nums2[i]>=s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=s.peek();
            }
            s.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    result[i]=ans[j];
                }
            }
        }
        return result;
    }
}
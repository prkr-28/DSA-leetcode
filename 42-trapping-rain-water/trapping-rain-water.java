class Solution {
    public int trap(int[] height) {
        int ans=0;
        int leftm=-1;
        int rightm=-1;
        int[] leftmax=new int[height.length];
        int[] rightmax=new int[height.length];
        for(int i=0;i<height.length;i++){
            if(leftm<height[i]){
                leftm=height[i];
            }
            leftmax[i]=Math.max(leftm,height[i]);
        }
        for(int i=height.length-1;i>=0;i--){
            if(rightm<height[i]){
                rightm=height[i];
            }
            rightmax[i]=Math.max(rightm,height[i]);
        }
        for(int i=0;i<height.length;i++){
            ans+=(Math.min(leftmax[i],rightmax[i])-height[i]);
        }

        return ans;
    }
}
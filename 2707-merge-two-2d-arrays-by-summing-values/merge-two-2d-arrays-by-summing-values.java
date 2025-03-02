class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]>arr=new ArrayList<>();
        int i=0;
        int j=0;
        int m=nums1.length;
        int n=nums2.length;
        while(i<m&&j<n){
            if(nums1[i][0]>nums2[j][0]){
                arr.add(nums2[j]);
                j++;
            }
            else if(nums1[i][0]<nums2[j][0]){
                arr.add(nums1[i]);
                i++;
            }
            else{
                arr.add(new int[]{nums1[i][0],nums1[i][1]+nums2[j][1]});
                i++;
                j++;
            }
        }

        while(i<m){
            arr.add(nums1[i]);
            i++;
        }
        while(j<n){
            arr.add(nums2[j]);
            j++;
        }
        return arr.toArray(new int[0][]);
    }
}
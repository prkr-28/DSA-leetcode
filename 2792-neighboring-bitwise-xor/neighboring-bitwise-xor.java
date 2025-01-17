class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int temp=derived[0];
        for(int i=1;i<derived.length;i++){
            temp=temp^derived[i];
        }
        if(temp==0){
            return true;
        }
        else{
            return false;
        }
    }
}
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>>res=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            List<Integer>arr=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    arr.add(1);
                }
                else{
                    int num=res.get(i-1).get(j)+res.get(i-1).get(j-1);
                    arr.add(num);
                }
            }
            res.add(arr);
        }
        return res.get(rowIndex);
    }
}
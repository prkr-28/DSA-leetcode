class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<Integer>st=new Stack<>();
        int n=positions.length;
        Integer[] actualposition=new Integer[n];
        for(int i=0;i<n;i++){
            actualposition[i]=i;
        }
        Arrays.sort(actualposition, (i, j) -> Integer.compare(positions[i], positions[j]));

        List<Integer>list=new ArrayList<>();

        for(int curridx:actualposition){
            if(directions.charAt(curridx)=='R'){
                st.push(curridx);
            }
            else{
                while(!st.isEmpty()&&healths[curridx]>0){
                    int topidx=st.pop();
                    if(healths[topidx]>healths[curridx]){
                        healths[topidx]-=1;
                        healths[curridx]=0;
                        st.push(topidx);
                    }
                    else if(healths[topidx]<healths[curridx]){
                        healths[curridx]-=1;
                        healths[topidx]=0;
                    }
                    else{
                        healths[curridx] = 0;
                        healths[topidx] = 0;
                    }
                }
            }
        }
        for(int i=0;i<healths.length;i++){
            if(healths[i]!=0){
                list.add(healths[i]);
            }
        }

        return list;
    }
}
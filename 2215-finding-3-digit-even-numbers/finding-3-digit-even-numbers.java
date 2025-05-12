class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq=new int[10];
        for(int i:digits){
            freq[i]++;
        }
        List<Integer>list=new ArrayList<>();
        for(int i=100;i<999;i++){
            boolean canform=true;
            if(i%2==0){
                Map<Integer,Integer>map=numbers(i);
                for(int digit:map.keySet()){
                    if (map.get(digit) > freq[digit]) {
                        canform = false;
                        break;
                    }
                }
                if(canform){
                    list.add(i);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public Map<Integer,Integer> numbers(int num){
        Map<Integer,Integer>map=new HashMap<>();
        while(num>0){
            int r=num%10;
            map.put(r,map.getOrDefault(r,0)+1);
            num=num/10;
        }
        return map;
    }
}
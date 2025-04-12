class Solution {
    public long countGoodIntegers(int n, int k) {
        int res=0;
        Set<String>set=new HashSet<>();
        int d=(n+1)/2;
        int start=(int)Math.pow(10,d-1);
        int end=(int)Math.pow(10,d)-1;

        for(int num=start;num<=end;num++){
            String lefthalf=Integer.toString(num);
            String full="";
            if(n%2==0){
                StringBuilder righthalf=new StringBuilder(lefthalf).reverse();
                full=lefthalf+righthalf.toString();
            }else{
                StringBuilder righthalf=new StringBuilder(lefthalf.substring(0,d-1)).reverse();
                full=lefthalf+righthalf;
            }
            long number=Long.parseLong(full);

            if(number%k!=0){
                continue;
            }
            char[] arr=full.toCharArray();
            Arrays.sort(arr);
            set.add(new String(arr));
        }

        long[] factorial=new long[11];
        factorial[0]=1;
        for(int i=1;i<11;i++){
            factorial[i]=factorial[i-1]*i;
        }
        for(String st:set){
            int[] count=new int[10];
            for(char ch:st.toCharArray()){
                count[ch-'0']++;
            }
            int totaldigits=st.length();
            int zerocount=count[0];
            int nonzero=totaldigits-zerocount;

            long permutations=nonzero*(factorial[totaldigits-1]);
            for(int i=0;i<count.length;i++){
                permutations/=factorial[count[i]];
            }
            res+=permutations;
        }
        return res;
    }
}
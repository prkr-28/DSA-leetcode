class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<double[]>pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                double div=(double)arr[i]/arr[j];
                pq.add(new double[]{div,arr[i],arr[j]});

                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        double[] res=pq.poll();
        return new int[]{(int)res[1],(int)res[2]};
    }
}
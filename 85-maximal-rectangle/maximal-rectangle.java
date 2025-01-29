class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        for (int i = 0; i < m; i++) {
            heights[i] = (matrix[0][i] == '1') ? 1 : 0;
        }
        int maxarea=area(heights);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='0'){
                    heights[j]=0;
                }
                else{
                    heights[j]+=1;
                }
            }
            maxarea=Math.max(maxarea,area(heights));
        }
        return maxarea;
    }

    public static int[] nsl(int[] heights){
        int n=heights.length;
        Stack<Integer>s=new Stack<>();
        int[] nsl=new int[n];
        for(int i=0;i<n;i++){
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        return nsl;
    }
    public static int[] nsr(int[] heights){
        int n=heights.length;
        Stack<Integer>s=new Stack<>();
        int[] nsr=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=n;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        return nsr;
    }
    public static int area(int[] heights){
        int[] left=nsl(heights);
        int[] right=nsr(heights);
        int maxarea=0;
        for(int i=0;i<heights.length;i++){
            int width=right[i]-left[i]-1;
            int a=width*heights[i];
            maxarea=Math.max(maxarea,a);
        }
        return maxarea;
    }
}
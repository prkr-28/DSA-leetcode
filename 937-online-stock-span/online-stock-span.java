class Pair{
    int i;
    int j;
    public Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class StockSpanner {
    Stack<Pair> stack=new Stack<>();
    public StockSpanner() {
        
    }
    public int next(int price) {
        int span=1;
        while(!stack.isEmpty()&&stack.peek().i<=price){
            span+=stack.peek().j;
            stack.pop();
        }
        stack.push(new Pair(price,span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
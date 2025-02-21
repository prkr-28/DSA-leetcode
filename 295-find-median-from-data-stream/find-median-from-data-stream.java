class MedianFinder {

    PriorityQueue<Integer>leftmaxheap;
    PriorityQueue<Integer>rightminheap;
    public MedianFinder() {
        leftmaxheap=new PriorityQueue<>(Collections.reverseOrder());
        rightminheap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftmaxheap.isEmpty()||num<leftmaxheap.peek()){
            leftmaxheap.add(num);
        }
        else{
            rightminheap.add(num);
        }
        if(leftmaxheap.size()-rightminheap.size()>1){
            int temp=leftmaxheap.poll();
            rightminheap.add(temp);
        }
        else if(leftmaxheap.size()<rightminheap.size()){
            leftmaxheap.add(rightminheap.poll());
        }
    }
    
    public double findMedian() {
        if(leftmaxheap.size()==rightminheap.size()){
            return (leftmaxheap.peek()+rightminheap.peek())/2.0;
        }
        else{
            return leftmaxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class ProductOfNumbers {

    List<Integer>arr;
    public ProductOfNumbers() {
        arr=new ArrayList<>();
        arr.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            arr.clear();
            arr.add(1);
        }
        else{
            arr.add(num*arr.get(arr.size()-1));
        }
    }
    
    public int getProduct(int k) {
        if(arr.size()<=k){
            return 0;
        }
        return arr.get(arr.size()-1)/arr.get(arr.size()-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
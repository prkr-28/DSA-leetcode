class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int count=recipes.length;
        HashSet<String>set=new HashSet<>();
        List<String>res=new ArrayList<>();
        for(int i=0;i<supplies.length;i++){
            set.add(supplies[i]);
        }
        boolean[] cooked=new boolean[recipes.length];
        Arrays.fill(cooked,false);
        while(count-- >0){
            for(int i=0;i<recipes.length;i++){
                if(cooked[i]){
                    continue;
                }
                boolean banpayega=false;
                for(int j=0;j<ingredients.get(i).size();j++){
                    if(!set.contains(ingredients.get(i).get(j))){
                        banpayega =true;
                        break;
                    }
                }
                if(banpayega==false){
                    set.add(recipes[i]);
                    res.add(recipes[i]);
                    cooked[i]=true;
                }
            }
        }
        return res;
    }
}
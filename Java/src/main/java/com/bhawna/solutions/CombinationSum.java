class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        dfsCombSum(candidates,target,0,new ArrayList<Integer>(),ans);
        return ans;
    }
    
    void dfsCombSum(int[] cand,int target,int index,List<Integer> subans, List<List<Integer>> ans){
        if(target<0)
            return;
        else if(target==0){
            ans.add(new ArrayList<Integer>(subans));
            return;
        }
        for(int i=index;i<cand.length;i++){
            subans.add(cand[i]);
            dfsCombSum(cand,target-cand[i],i,subans,ans);
            subans.remove(subans.size()-1);
        }
    }
}

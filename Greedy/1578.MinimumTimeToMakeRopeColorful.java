class Solution {
    public int minCost(String c, int[] need) {
        int res=0;
        for(int i=1;i<c.length();i++){
            if(c.charAt(i)==c.charAt(i-1)){
                if(need[i-1]<=need[i]){
                    res+=need[i-1];
                    need[i-1]=0;
                }else{
                    res+=need[i];
                    need[i]=need[i-1];
                }
            }
        }
        return res;
    }
}

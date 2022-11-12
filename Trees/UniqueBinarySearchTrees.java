//Leetcode 96. Unique Binary Search Trees
class Solution {
    public int catalan(int n){
        int catln[]=new int[n+1];
        catln[0]=1;
        catln[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                catln[i]+=catln[j]*catln[i-j-1];
            }
        }
        return catln[n];
    }
    public int numTrees(int n) {
        return catalan(n); //catalan take all number as root and find its combination like if n=4 (c0*c3)+(c1*c2)+(c2*c1)+(c3*c0);
    }
}

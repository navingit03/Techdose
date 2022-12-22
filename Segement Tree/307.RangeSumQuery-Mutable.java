class NumArray {
    int []st;
    int n;
    public void buildST(int stind,int []nums,int s,int e){
        if(s>e) return;
        if(s==e){
            st[stind]=nums[s];
            return;
        }
        int mid=s+(e-s)/2;
        buildST(stind*2+1,nums,s,mid);
        buildST(stind*2+2,nums,mid+1,e);
        st[stind]=st[stind*2+1]+st[stind*2+2];
    }
    public int rangeSum(int stind,int s,int e,int qs,int qe){
        if(qe<s||qs>e) return 0; //no overlap
        if(qs<=s && e<=qe) return st[stind]; //total overlap
        int mid=s+(e-s)/2;
        //partial overlap
        int leftSum=rangeSum(2*stind+1,s,mid,qs,qe);
        int rightSum=rangeSum(2*stind+2,mid+1,e,qs,qe);
        return leftSum+rightSum;
    }
    public void updateST(int stind,int s,int e,int index,int val){
        if(index<s||index>e) return; //index is not in current range
        if(s==e) //if correct index is found
        { 
            st[stind]=val;
            return;
        }
        int mid=s+(e-s)/2;
        updateST(stind*2+1,s,mid,index,val);
        updateST(stind*2+2,mid+1,e,index,val);
        st[stind]=st[2*stind+1]+st[2*stind+2]; //updating after update of val
    }
    public NumArray(int[] nums) {
        n=nums.length;
        int height=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int maxsize=(1<<height)-1;
        st=new int[maxsize];
        buildST(0,nums,0,n-1);
    }
    
    public void update(int index, int val) {
        updateST(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return rangeSum(0,0,n-1,left,right);
    }
}

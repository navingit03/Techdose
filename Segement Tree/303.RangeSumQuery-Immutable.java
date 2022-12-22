class NumArray {
    int st[];
    int n;
    public int buildST(int st_idx,int []nums,int s,int e){
        if(s==e){
            return st[st_idx]=nums[s];
        }
        int mid=s+(e-s)/2;
        buildST(2*st_idx+1,nums,s,mid);
        buildST(2*st_idx+2,nums,mid+1,e);
        return st[st_idx]=st[2*st_idx+1]+st[2*st_idx+2];
    }
    public  int getRange(int sti,int s,int e,int qs,int qe){
        if(e<qs||s>qe) //no overlap
        {
            return 0;
        }
        if(qs<=s && e<=qe) //total overlap
        {
            return st[sti];
        }
        int mid=s+(e-s)/2;
        //partial overlap
        int leftsum=getRange(2*sti+1,s,mid,qs,qe);
        int rightsum=getRange(2*sti+2,mid+1,e,qs,qe);
        return leftsum+rightsum;
    }
    public NumArray(int[] nums) {
        n=nums.length;
        int height=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int maxsize=(1<<height)-1;
        st=new int[maxsize];
        buildST(0,nums,0,nums.length-1);
    }
    
    public int sumRange(int left, int right) {
        return getRange(0,0,n-1,left,right);
    }
}

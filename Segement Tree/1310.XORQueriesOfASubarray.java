class Solution {
    int st[];
    public void buildST(int stind,int[] arr,int s,int e){
        if(s>e) return;
        if(s==e){
            st[stind]=arr[s];
            return;
        }
        int mid=s+(e-s)/2;
        buildST(2*stind+1,arr,s,mid);
        buildST(2*stind+2,arr,mid+1,e);
        st[stind]=st[2*stind+1]^st[2*stind+2]; //updating parent with xor of childs
    }
    public int query(int stind,int s,int e,int qs,int qe){
        if(qe<s||e<qs) return 0; //no overlap
        if(qs<=s&&e<=qe) return st[stind]; //total overlap
        int mid=s+(e-s)/2;
        //partial overlap
        int leftXor=query(2*stind+1,s,mid,qs,qe);
        int rightXor=query(2*stind+2,mid+1,e,qs,qe);
        return leftXor^rightXor;
    }
    public int[] xorQueries(int[] arr, int[][] q) {
        int n=arr.length;
        int height=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int size=(1<<height)-1;
        st=new int[size];
        buildST(0,arr,0,n-1);
        int ans[]=new int[q.length];
        for(int i=0;i<q.length;i++){
            ans[i]=query(0,0,n-1,q[i][0],q[i][1]);
        }
        return ans;
    }
}

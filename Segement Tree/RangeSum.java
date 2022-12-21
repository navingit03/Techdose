public class RangeSum {
    public static int st[];
    public static void buildST(int stidx,int arr[],int s,int e){
        if(s>e) return;
        if(s==e){
            st[stidx]=arr[s];
            return;
        }
        int mid=s+(e-s)/2;
        buildST(2*stidx, arr, s, mid);
        buildST(2*stidx+1, arr, mid+1, e);
        st[stidx]=st[2*stidx]+st[2*stidx+1];
    }
    public static int query(int qs,int qe,int stidx,int s,int e){
        if(qs>e||qe<s) return 0; //no overlap
        if(s>=qs && e<=qe) return st[stidx]; //total overlap
        int mid=s+(e-s)/2;
        int lsum=query(qs, qe, 2*stidx, s, mid);
        int rsum=query(qs, qe, 2*stidx+1, mid+1, e);
        return lsum+rsum;
    }
    public  static void updatenode(int stidx,int s,int e,int pos,int newval){
        if(s>pos||e<pos) return;
        if(s==e){
            st[stidx]=newval;
            return;
        }
        int mid=s+(e-s)/2;
        updatenode(2*stidx, s, mid, pos, newval);
        updatenode(2*stidx+1, mid+1, e, pos, newval);
        st[stidx]=st[2*stidx]+st[2*stidx+1];
    }
    public static void main(String[] args) {
        int n=6;
        int arr[]={1,3,2,-2,4,5};
        int height=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int maxsize=(1<<height)-1;
        st=new int[maxsize];
        int stidx=1;
        int s=0,e=n-1;
        buildST(stidx,arr,s,e);
        for(int i=0;i<maxsize;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(2,4,stidx,s,e));
        System.out.println(query(5,5,stidx,s,e));

        arr[2]=100; //update arr
        updatenode(stidx,s,e,2,100);
        for(int i=0;i<maxsize;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(2,4,stidx,s,e));
        System.out.println(query(1,4,stidx,s,e));
    }
}

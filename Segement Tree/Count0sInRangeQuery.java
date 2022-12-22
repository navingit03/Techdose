public class Count0sInRangeQuery {
    public static int st[];
    public static void buildST(int stidx,int arr[],int s,int e){
        if(s>e) return;
        if(s==e){
            st[stidx]=(arr[s]==0?1:0); //if arr[s]=0 then making st[stind] as 1(count)
            return;
        }
        int mid=s+(e-s)/2;
        buildST(2*stidx+1, arr, s, mid);
        buildST(2*stidx+2, arr, mid+1, e);
        st[stidx]=st[2*stidx+1]+st[2*stidx+2];
    }
    public static int query(int qs,int qe,int stidx,int s,int e){
        if(qs>e||qe<s) return 0; //no overlap
        if(s>=qs && e<=qe) return st[stidx]; //total overlap
        int mid=s+(e-s)/2;
        int l0sum=query(qs, qe, 2*stidx+1, s, mid);
        int r0sum=query(qs, qe, 2*stidx+2, mid+1, e);
        return l0sum+r0sum;
    }
    public  static void updatenode(int stidx,int s,int e,int pos,int newval){
        if(s>pos||e<pos) return; //if index is not in range of s,e
        if(s==e){
            st[stidx]=(newval==0?1:0); //if new val is 0 then making st[stind]=1(count)
            return;
        }
        int mid=s+(e-s)/2;
        updatenode(2*stidx+1, s, mid, pos, newval);
        updatenode(2*stidx+2, mid+1, e, pos, newval);
        st[stidx]=st[2*stidx]+st[2*stidx+1]; //updating parent with count(leftchild+rigthchild)
    }
    public static void main(String[] args) {
        int n=6;
        int arr[]={2,0,5,0,0,5};
        int height=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int size=(1<<height)-1;
        st=new int[size];
        buildST(0,arr,0,n-1); //building segement tree
        for(int i=0;i<size;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(0,1,0,0,n-1)); //query call
        System.out.println(query(1,4,0,0,n-1));

        int index=1,val=2;
        arr[index]=val; //update arr of index at val
        updatenode(0,0,n-1,index,val); //updating segement tree
        for(int i=0;i<size;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(0,1,0,0,n-1));
        System.out.println(query(1,4,0,0,n-1));
    }
}

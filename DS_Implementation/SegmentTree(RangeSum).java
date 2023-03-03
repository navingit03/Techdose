package BuildDS;

public class SegmentTree {
    static int st[];
    public static void buildST(int stidx,int arr[],int s,int e)
    {
        if(s>e) return;
        if(s==e)
        {
            st[stidx]=arr[e];
            return;
        }
        int mid=s+(e-s)/2;
        buildST(2*stidx, arr, s, mid);
        buildST(2*stidx+1, arr, mid+1, e);
        st[stidx]=st[2*stidx]+st[2*stidx+1];
        return;
    }
    public static int query(int qs,int qe,int stidx,int s,int e)
    {
        if(qe<s || e<qs) return 0; //no overlap
        if(qs<=s && e<=qe) return st[stidx]; //total overlap
        int mid=s+(e-s)/2;
        int leftsum=query(qs, qe, 2*stidx, s, mid);
        int rightsum=query(qs, qe, 2*stidx+1, mid+1, e);
        return leftsum+rightsum;
    }
    public static void updatenode(int stidx,int s,int e,int pos,int value)
    {
        if(pos<s || e<pos) return;
        if(s==e) 
        {
            st[stidx]=value;
            return;
        }
        int mid=s+(e-s)/2;
        updatenode(2*stidx, s, mid, pos, value);
        updatenode(2*stidx, mid+1, e, pos, value);
        st[stidx]=st[2*stidx]+st[2*stidx+1];
    }
    public static void main(String[] args) {
        int arr[]={1,3,2,4,6,5};
        int n=arr.length;
        int height=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int size=(1<<height)-1;
        st=new int[size];
        int s=0,e=n-1;
        int stindx=1;
        buildST(stindx,arr,s,e);
        for(int i=0;i<size;i++)
        {
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(2,4,stindx,s,e));
        System.out.println(query(0,4,stindx,s,e));
        arr[2]=100; //update arr
        updatenode(stindx,s,e,2,100);
        for(int i=0;i<size;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(2,4,stindx,s,e));
        System.out.println(query(0,4,stindx,s,e));
    }
}

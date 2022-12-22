public class MinRangeQuery {
    public static int st[];
    public static void buildST(int stind,int []arr,int s,int e){
        if(s>e) return; //invaild range
        if(s==e) //child node of st
        {
            st[stind]=arr[s];
            return;
        }
        int mid=s+(e-s)/2;
        buildST(2*stind+1, arr, s, mid);
        buildST(2*stind+2, arr, mid+1, e);
        st[stind]=Math.min(st[2*stind+1], st[2*stind+2]); //updating parent node with min of childs
    }
    public static int query(int stidx,int s,int e,int qs,int qe){
        if(qe<s||e<qs) return Integer.MAX_VALUE; //no overlap so max val
        if(s>=qs&&e<=qe) //total overlap
        {
            return st[stidx];
        }
        int mid=s+(e-s)/2;
        //partial overlap
        int leftMin=query(2*stidx+1, s, mid, qs, qe);
        int rightMin=query(2*stidx+2, mid+1, e, qs, qe);
        return Math.min(leftMin, rightMin); //min of left and right query
    }
    public static void updatenode(int stidx,int s,int e,int pos,int val){
        if(s>pos||e<pos) return; //index not in range
        if(s==e){
            st[stidx]=val; //child node of st[stind]=val
            return;
        }
        int mid=s+(e-s)/2;
        updatenode(2*stidx+1, s, mid, pos, val);
        updatenode(2*stidx+2, mid+1, e, pos, val);
        st[stidx]=Math.min(st[2*stidx+1],st[2*stidx+2]); //updating parents
    }
    public static void main(String[] args) {
        int n=6;
        int arr[]={2,1,0,4,3,7};
        int height=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int size=(1<<height)-1;
        st=new int[size];
        buildST(0,arr,0,n-1);
        for(int i=0;i<size;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(0,0,n-1,0,1)); //1
        System.out.println(query(0,0,n-1,3,5)); //3
        System.out.println(query(0,0,n-1,0,5)); //0
        int index=1,val=10;
        arr[index]=val;
        updatenode(0,0,n-1,index,val);
        for(int i=0;i<size;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(0,0,n-1,0,1)); //1
        System.out.println(query(0,0,n-1,3,5)); //3
        System.out.println(query(0,0,n-1,0,5)); //0
    }
}

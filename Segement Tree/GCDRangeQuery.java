public class GCDRangeQuery {
    public static int st[];
    public static int gcd(int a,int b){
        return (b==0?a:gcd(b, a%b)); //gcd of two numbers
    }
    public static void buildST(int stind,int []arr,int s,int e){
        if(s>e) return; //invaild range
        if(s==e)
        {
            st[stind]=arr[s]; //child node of st
            return;
        }
        int mid=s+(e-s)/2;
        buildST(2*stind+1, arr, s, mid);
        buildST(2*stind+2, arr, mid+1, e);
        st[stind]=gcd(st[2*stind+1], st[2*stind+2]); //updating parent node with gcd of childs
    }
    public static int query(int stind,int s,int e,int qs,int qe){
        if(qe<s||e<qs) return 0; //no overlap
        if(qs<=s&&e<=qe) //total overlap
        {
            return st[stind];
        }
        int mid=s+(e-s)/2;
        //partial overlap
        int leftGCD=query(2*stind+1, s, mid, qs, qe);
        int rightGCD=query(2*stind+2, mid+1, e, qs, qe);
        return gcd(leftGCD, rightGCD); //gcd of left and right query
    }
    public static void updatenode(int stind,int s,int e,int pos,int val){
        if(pos<s||pos>e) return; //index not in range
        if(s==e)
        {
            st[stind]=val; //child node of st[stind]=val
            return;
        }
        int mid=s+(e-s)/2;
        updatenode(2*stind+1, s, mid, pos, val);
        updatenode(2*stind+2, mid+1, e, pos, val);
        st[stind]=gcd(st[2*stind+1], st[2*stind+2]); //updating parents
    }
    public static void main(String[] args) {
        int n=5;
        int arr[]={2,3,60,90,50};
        int height=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int size=(1<<height)-1;
        st=new int[size];
        buildST(0,arr,0,n-1);
        for(int i=0;i<size;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(0,0,n-1,1,3));
        System.out.println(query(0,0,n-1,2,4));
        System.out.println(query(0,0,n-1,0,2));
        
        int index=1,val=30;
        arr[index]=val;
        updatenode(0,0,n-1,index,val); //updating value
        for(int i=0;i<size;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(0,0,n-1,1,3));
        System.out.println(query(0,0,n-1,2,4));
        System.out.println(query(0,0,n-1,0,2));
    }
}

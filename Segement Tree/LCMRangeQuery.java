public class LCMRangeQuery {
    public static int st[];
    public static int gcd(int a,int b){
        return (b==0?a:gcd(b,a%b)); //gcd of two numbers
    }
    public static int lcm(int a,int b){
        return (a*b)/gcd(a,b); //lcm*gcd=a*b
    }
    public static void buildST(int stind,int []arr,int s,int e){
        if(s>e) return; //invaild range
        if(s==e){
            st[stind]=arr[s]; //child node of st
            return;
        }
        int mid=s+(e-s)/2;
        buildST(2*stind+1, arr, s, mid);
        buildST(2*stind+2, arr, mid+1, e);
        st[stind]=lcm(st[2*stind+1],st[2*stind+2]); //updating parent node with lcm of childs
    }
    public static int query(int stind,int s,int e,int qs,int qe){
        if(qe<s||e<qs) return 1; //no overlap so 1 for lcm
        if(qs<=s&&e<=qe) //total overlap
        {
            return st[stind];
        }
        int mid=s+(e-s)/2;
        //partial overlap
        int leftLCM=query(2*stind+1, s, mid, qs, qe);
        int rightLCM=query(2*stind+2, mid+1, e, qs, qe);
        return lcm(leftLCM, rightLCM); //lcm of left and right query
    }
    public static void updatenode(int stind,int s,int e,int pos,int val){
        if(pos<s||e<pos) return; //index not in range
        if(s==e){
            st[stind]=val; //child node of st[stind]=val
            return;
        }
        int mid=s+(e-s)/2;
        updatenode(2*stind+1, s, mid, pos, val);
        updatenode(2*stind+2, mid+1, e, pos, val);
        st[stind]=lcm(st[2*stind+1], st[2*stind+2]); //updating parents
    }
    public static void main(String[] args) {
        int n=11;
        int arr[]={5,7,5,2,10,12,11,17,14,1,44};
        int height=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int size=(1<<height)-1;
        st=new int[size];
        buildST(0,arr,0,n-1);
        for(int i=0;i<size;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(0,0,n-1,2,5));
        System.out.println(query(0,0,n-1,5,10));
        System.out.println(query(0,0,n-1,0,10));
        
        int index=7,val=100;
        arr[index]=val;
        updatenode(0,0,n-1,index,val); //updating value
        for(int i=0;i<size;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
        System.out.println(query(0,0,n-1,2,5));
        System.out.println(query(0,0,n-1,5,10));
        System.out.println(query(0,0,n-1,0,10));
    }
}

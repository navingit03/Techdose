/* 
input :     output
5 7    
1 0 3 0 5  
1 2         3 (2nd zero is in 3rd index)
2 1 5  
1 1         3 (1nd zero is in 3rd index)
2 3 10      
1 1        -1 (no zero in array)
2 4 0   
1 2         4 (1nd zero is in 4th index)
*/
import java.util.*;
public class FindKthZero_index {
    public static int st[];
    public static void buildSt(int stind,int s,int e,int []arr){
        if(s>e) //invalid condition
        {
            return;
        }
        if(s==e) //base 
        {
            if(arr[s]==0) //if arr[s]==0 then making st[stind] as 1(count)
            {
                st[stind]=1;
            }else ////if arr[s]!=0 then making st[stind] as 0(count)
            {
                st[stind]=0;
            }
            return;
        }
        int mid=s+(e-s)/2;
        buildSt(2*stind+1, s, mid, arr);
        buildSt(2*stind+2, mid+1, e, arr);
        st[stind]=st[2*stind+1]+st[2*stind+2]; //updating parent node with sum of childs
    }
    public static int query(int stind,int s,int e,int k){
        if(st[stind]<k) //if total no of zero in st[stind] is less than k (return -1)
        {
            return -1;
        }
        if(s==e) //if Kth zero's index is found
        {
            return s;
        }
        int mid=s+(e-s)/2;
        if((st[2*stind+1])>=k) //if left count of zero >= k then move to left
        {
            return query(2*stind+1, s, mid, k);
        }else //else move to right
        {
            return query(2*stind+2, mid+1, e, k-(st[2*stind+1])); //sending k-st[2*stind+1] (left side 0's count) 
        }
    }
    public static void updateST(int stind,int s,int e,int index,int value){
        if(index<s||e<index) //if index is not in range of s,e
        {
            return;
        }
        if(s==e)
        {
            st[stind]=((value==0)?1:0); //if new val is 0 then making st[stind]=1(count)
            return;
        }
        int mid=s+(e-s)/2;
        updateST(2*stind+1, s, mid, index, value);
        updateST(2*stind+2, mid+1, e, index, value);
        st[stind]=st[2*stind+1]+st[2*stind+2]; //updating parent with count(leftchild+rigthchild)
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //input array size
        int q=sc.nextInt(); //total no of update and query
        int arr[]=new int[n]; //creating input array
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt(); //getting values of arr
        }
        int height=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1; //finding height of st
        int size=(1<<height)-1; //find size of st array
        st=new int[size]; //creating st array
        buildSt(0,0,n-1,arr); //build st function
        for(int i=0;i<q;i++)
        {
            int task=sc.nextInt(); //getting task (update or query)
            if(task==1) //task==1 means query
            {
                int k=sc.nextInt(); //getting k to find Kth zero index
                int KthZeroIndex=query(0,0,n-1,k); //return KthZero index (if no k zero return -1;)
                System.out.println("KthZero index : "+KthZeroIndex);
            }
            else if(task==2) //task==2 means update
            {
                int index=sc.nextInt(); //getting array's index to update
                int value=sc.nextInt(); //value to be updated
                arr[index]=value; //changing value in arr
                updateST(0,0,n-1,index,value); //update function call
            }
        }
        sc.close();
    }
}

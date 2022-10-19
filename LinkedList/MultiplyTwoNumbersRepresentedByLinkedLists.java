//Multiply two numbers represented by Linked Lists
//TC o(l1.size+l2.size)
public class MultiplyTwoNumbers{
    static class node{
        int val;
        node next;
        node(int data){
            val=data;
        }
    }
    static int multiple(node l1,node l2){
        int num1=0,num2=0;
        int mod=(int)1e9+7;
        while(l1!=null||l2!=null){
            if(l1!=null){
                num1=(num1*10)%mod+l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                num2=(num2*10)%mod+l2.val;
                l2=l2.next;
            }
        }
        return ((num1%mod)*(num2%mod))%mod;
    }
    public static void main(String []args){
        node l1=new node(9);
        l1.next=new node(4);
        l1.next.next=new node(6);
        node l2=new node(8);
        l2.next=new node(4);
        System.out.print(multiple(l1,l2));
    }
}

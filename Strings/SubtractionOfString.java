public class SubtractString {
    public static boolean isS1Smaller(String s1,String s2)
    {
        if(s1.length()<s2.length())
        {
            return true;
        }
        if(s1.length()>s2.length())
        {
            return false;
        }
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)<s2.charAt(i))
            {
                return true;
            }else if(s1.charAt(i)>s2.charAt(i)){
                return false;
            }
        }
        return false; //same so not smaller
    }
    public static void main(String[] args) {
        String s1="1234";
        String s2="1434";
        boolean neg=false;
        if(isS1Smaller(s1,s2)) //to make s1 as bigger number
        {
            String temp=s1;
            s1=s2;
            s2=temp;
            neg=true; //to return bal in -ve
        }
        String ans="";
        s1=new StringBuilder(s1).reverse().toString(); //as we calculate form right to left(in subtraction)
        s2=new StringBuilder(s2).reverse().toString();
        int carry=0;
        int subtract=0;
        for(int i=0;i<s2.length();i++)
        {
            subtract=(s1.charAt(i)-'0')-(s2.charAt(i)-'0')-carry; //decreasing by -1 (if carry = 1)
            if(subtract<0) //if negative number is sub
            {
                carry=1; //get one carry
                subtract=subtract+10; //sub+=10 as we borrow 1 as carry
            }
            else{
                carry=0;
            }
            ans+=subtract+""; //adding in ans
        }
        for(int i=s2.length();i<s1.length();i++) //as s1 is bigger adding balance string
        {
            subtract=(s1.charAt(i)-'0')-carry; //as s2 is calculated fully
            if(subtract<0)
            {
                carry=1;
                subtract=subtract+10;
            }else
            {
                carry=0;
            }
            ans+=subtract+"";
        }
        String res=new StringBuilder(ans).reverse().toString();
        System.out.print((neg==true)?"-"+res:res);
    }
}

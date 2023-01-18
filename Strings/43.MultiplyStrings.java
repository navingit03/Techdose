class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0"; //if any num is 0
        int arr[]=new int[num1.length()+num2.length()]; //max length will be m+n
        int m=num1.length();
        int n=num2.length();
        
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0'); //multipling digits by taking one digit in num1 and multiplying with all digits in num2
                int index=i+j+1; //curr index will be from right to left
                int carryindex=i+j; //carryindex will be by before one index
                int sum=arr[index]+mul; //adding already present value 
                arr[index]=sum%10; //only one digit we need to put so %10
                arr[carryindex]+=sum/10; //carry added with sum/10
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++)
        {
            if(!(sb.length()==0 && arr[i]==0))
            {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}

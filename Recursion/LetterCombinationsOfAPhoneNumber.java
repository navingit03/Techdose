//Leetcode 17. Letter Combinations of a Phone Number
class Solution {
    List<String> list=new ArrayList();
    public void combination(String []arr,String curr,int num)
    {
        if(num==0) //if num==0 
        {
            list.add(curr); //add curr
            return;
        }
        String str=arr[num%10]; //arr[last digit of curr num]
        for(int i=0;i<str.length();i++)
        {
            combination(arr,str.charAt(i)+curr,num/10);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return list; //if input is null
        int num=Integer.parseInt(digits); //converting string into num
        String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; //string for all digits
        combination(arr,"",num); //function call
        return list;
    }
}

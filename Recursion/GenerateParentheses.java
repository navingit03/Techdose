//Leetcode 22. Generate Parentheses
//method 1 Using dfs
class Solution 
{
    List<String> list=new ArrayList<>();
    public boolean valid(char []arr)
    {
        int balance=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='(') balance++;
            else balance--;
            if(balance<0) //if ) comes before ( (i.e count of ')' is > count of '(') return false
            {
                return false;
            }
        }
        return (balance==0); //if count of both is equal return true else false
    }
    public void dfs(char []arr,int pos){
        if(pos==arr.length) //checking if array if filled fully
        {
            if(valid(arr)) //checking if array is valid or not
            {
                list.add(new String(arr));
            }
            return;
        }
        else
        {
            arr[pos]='(';
            dfs(arr,pos+1); //dfs call
            arr[pos]=')';
            dfs(arr,pos+1); //dfs call
        }
    }
    public List<String> generateParenthesis(int n)
    {
        char arr[]=new char[n*2]; //creating character of size 2*n
        dfs(arr,0);
        return list;
    }
}

//method 2 Using backtracking
class Solution {
    List<String> list=new ArrayList<>();
    public void backtrack(StringBuilder sb,int open,int close,int n)
    {
        if(sb.length()==2*n) //if valid string is build then add it to list
        {
            list.add(sb.toString());
            return;
        }
        if(open<n)
        {
            sb.append("(");
            backtrack(sb,open+1,close,n);
            sb.deleteCharAt(sb.length()-1); //backtracking
        }
        if(close<open) //if close is < open we need to add close to sb
        {
            sb.append(")");
            backtrack(sb,open,close+1,n);
            sb.deleteCharAt(sb.length()-1); //bactracking
        }
    }
    public List<String> generateParenthesis(int n){
        backtrack(new StringBuilder(),0,0,n); //method calling
        return list;
    }
}

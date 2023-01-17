class Solution {
    TrieNode root;
    class TrieNode
    {
        TrieNode next[]=new TrieNode[2];
    }
    public void insert(int num)
    {
        TrieNode temp=root;
        for(int i=31;i>=0;i--)
        {
            int currbit=(num>>i)&1;
            if(temp.next[currbit]==null)
            {
                temp.next[currbit]=new TrieNode();
            }
            temp=temp.next[currbit];
        }
    }
    public int findpair(int num)
    {
        int ans=0;
        TrieNode temp=root;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>i)&1;
            int req=(bit==0)?1:0; //needed to find opposite bit
            if(temp.next[req]!=null)
            {
                ans=ans|(1<<i); //setting 1 to curr bit of answer
                temp=temp.next[req]; //going to opp bit
            }
            else //if req is not found
            {
                temp=temp.next[bit]; //going to available bit
            }
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        int max_xor=0;
        root=new TrieNode();
        for(int i=0;i<nums.length;i++)
        {
            insert(nums[i]);
            max_xor=Math.max(max_xor,findpair(nums[i]));
        }
        return max_xor;
    }
}

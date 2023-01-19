class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]=new int[26];
        int max=0;
        for(int i=0;i<tasks.length;i++)
        {
            freq[tasks[i]-'A']++;
            max=Math.max(freq[tasks[i]-'A'],max);
        }
        int chuncks=max-1;
        int idleSpot=(chuncks)*(n+1);
        int last=0;
        for(int i=0;i<25;i++)
        {
            if(freq[i]==max)
            {
                last++;
            }
        }
        return Math.max(tasks.length,idleSpot+last);
    }
}

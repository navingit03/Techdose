class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas=0,totalcost=0;
        for(int i=0;i<gas.length;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
        }
        if(totalgas<totalcost) return -1;
        int st=0,balgas=0;
        for(int i=0;i<gas.length;i++){
            balgas+=(gas[i]-cost[i]);
            if(balgas<0){
                st=i+1;
                balgas=0;
            }
        }
        return st;
    }
}

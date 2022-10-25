//Leetcode 853. Car Flee
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>(); //stack to add time taken by car to reach target
        int[][] sortpos = new int[position.length][2]; //to sort the position array( with speed array),so we created 2d array
        for (int i = 0; i < position.length; i++) {
            sortpos[i][0] = position[i];
            sortpos[i][1] = speed[i];
        }

        Arrays.sort(sortpos, (a,b) -> a[0]-b[0]); //sorting the array according to sort the position array
        for (int i = sortpos.length - 1; i >= 0; i--) {
            double currentTime = (double) (target - sortpos[i][0]) / sortpos[i][1]; //currtime=d/s (d=target-pos , s=speed)
            if (!stack.isEmpty() && currentTime <= stack.peek())  //if(currtime<=top then all the car's time>top will be in same fleet)
            {
                continue;
            } else {
                stack.push(currentTime); //adding if currtime> top
            }
        }
        return stack.size();
    }
}

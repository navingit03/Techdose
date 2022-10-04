//leetcode 54. Spiral Matrix
//Spiral matrix using four direction right,left,top,bottom
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<Integer>();
        int d=0;
        int top=0,left=0,right=matrix[0].length-1,bottom=matrix.length-1;
        while(left<=right&&top<=bottom){
            if(d==0){
                for(int i=left;i<=right;i++){
                    ans.add(matrix[top][i]);
                }
                top++;
            }
            else if(d==1){
                for(int i=top;i<=bottom;i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }
            else if(d==2){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            else{
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            d=(d+1)%4;
        }
        return ans;
    }
}

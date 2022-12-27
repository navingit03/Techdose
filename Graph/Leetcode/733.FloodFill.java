//TC: O(n*m)
class Solution {
    public void dfs(int[][] image, int i, int j,int prev,int color){
        if(i<0||j<0||j>=image[0].length||i>=image.length) return; //invalid index
        if(image[i][j]!=prev||image[i][j]==color) return; //if curr is not prev or curr is new return
        image[i][j]=color; //making prev to new color
        dfs(image,i-1,j,prev,color);
        dfs(image,i+1,j,prev,color);
        dfs(image,i,j-1,prev,color);
        dfs(image,i,j+1,prev,color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r=image.length;
        int c=image[0].length;
        dfs(image,sr,sc,image[sr][sc],color); //sending prev and new color
        return image;
    }
}

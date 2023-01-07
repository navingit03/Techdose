//133. Clone Graph by simple dfs and visited Node array
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node dfs(Node node,Node []visited)
    {
        if(visited[node.val]!=null) //if already copy created the return it
        {
            return visited[node.val];
        }
        Node newnode=new Node(node.val); //creating newnode for node.val
        visited[node.val]=newnode; //put the new node in visited
        for(Node neighbor:node.neighbors) //neighbor nodes of node
        {
            newnode.neighbors.add(dfs(neighbor,visited)); //adding neighbors for newnode
        }
        return visited[node.val]; //return newnode or visited[node.val] as both are same
    }
    public Node cloneGraph(Node node) {
        if(node==null) return null; //if node==null return null
        Node visited[]=new Node[101]; //creating n no of node class
        dfs(node,visited); //dfs call
        return visited[node.val]; //newly created in visited nodes for input node.val
    }
}

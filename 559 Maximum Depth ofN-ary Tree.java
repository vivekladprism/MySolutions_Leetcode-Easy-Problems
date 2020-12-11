/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        if(root == null)
            return 0;
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty())
        {
            // increment depth;
            depth ++;
            
            //for size of queue do poll and add children of those nodes to queue
            int size = queue.size();
            for(int i = 0 ; i < size; i++)
            {
                Node curr = queue.poll();
                if(curr.children == null)
                    continue;
                for(Node child : curr.children)
                    queue.offer(child);
            }
        }
        return depth;
    }
}
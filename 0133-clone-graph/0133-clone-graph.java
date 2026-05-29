/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() { val = 0; neighbors = new ArrayList<Node>(); }
    public Node(int _val) { val = _val; neighbors = new ArrayList<Node>(); }
    public Node(int _val, ArrayList<Node> _neighbors) { val = _val; neighbors = _neighbors; }
}
*/

import java.util.*;

class Solution {
    // Map to keep track of visited original nodes and their corresponding clones
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        // If we have already cloned this node, return the stored clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        // Create the clone for the current node
        Node clone = new Node(node.val);
        visited.put(node, clone);
        
        // Iterate through neighbors and recursively clone them
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        
        return clone;
    }
}
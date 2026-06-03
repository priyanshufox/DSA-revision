package graphs;
import java.util.*;


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


public class CloneGraph{

    private Map<Integer,Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null )return null;

        Node copy = new Node(node.val);
        visited.put(copy.val,copy);

        for(Node it : node.neighbors){
            if(!visited.containsKey(it.val)){
                Node newcopy = cloneGraph(it);
                copy.neighbors.add(newcopy);
            }
            else{
                copy.neighbors.add(visited.get(it.val));
            }
        }
        return copy;
    }
    
     public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph cg = new CloneGraph();
        Node clonedNode = cg.cloneGraph(node1);

        System.out.println("Original Node: " + node1.val);
        System.out.println("Cloned Node: " + clonedNode.val);
    }


}

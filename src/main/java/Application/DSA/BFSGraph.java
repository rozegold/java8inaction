package Application.DSA;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BFSGraph {


    private HashMap<Integer, Node> nodeLookUp = new HashMap<>();

    public class Node {
        private int id;
        private LinkedList<Node> adjacent = new LinkedList<Node>();

        public Node(int id) {
            this.id = id;
        }
    }

    public Node getNode(int d) {
        return nodeLookUp.get(d);
    }

    public void addEdge(int source, int destination) {
        Node s = new Node(source);
        Node d = new Node(destination);
        s.adjacent.add(d);
    }


    public boolean hasPathBFS(int source, int destination){
        Node s = new Node(source);
        Node d = new Node(destination);
        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(s);

        while(!nextToVisit.isEmpty()){
            Node node = nextToVisit.remove();
            if(node == d)
                return true;

            if(visited.contains(node.id))
                continue;

            visited.add(node.id);

            for (Node child : node.adjacent){
                nextToVisit.add(child);
            }
        }

        return false;
    }
}

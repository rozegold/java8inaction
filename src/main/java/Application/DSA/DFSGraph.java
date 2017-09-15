package Application.DSA;

import Application.Application;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DFSGraph {

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

    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node s, Node d, HashSet<Integer> visited) {
        if(visited.contains(s.id))
            return false;

        visited.add(s.id);

        if(s == d){
            return true;
        }

        for(Node child : s.adjacent){
            if(hasPathDFS(child, d, visited))
                return true;
        }

        return false;

    }
}

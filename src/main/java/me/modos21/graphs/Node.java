package me.modos21.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Node {

    char name;

    Map<Node, Integer> neighbours;

    public Node(char name, Map<Node, Integer> neighbours) {
        this.name = name;
        this.neighbours = neighbours;
    }

    public Node(char name) {
        this.name = name;
        this.neighbours = new HashMap<>();
    }

    public void addEdge(Node to, int length) {
        if (!neighbours.containsKey(to)) {
            neighbours.put(to, length);
            to.addEdge(this, length);
        }
    }

    public void removeEdge(final Node to) {
        if (neighbours.containsKey(to)) {
            neighbours.remove(to);
            to.removeEdge(this);
        }
    }

    /**
     * Calculates the distance to a given node form this one
     * @param a the node to find the distance to
     * @return distance to node, or -1 if there is no connection to it
     */
    public int distanceToNeighbour(Node a) {
        if (a == this) {
            return 0;
        }
        if (neighbours.containsKey(a)) {
            return neighbours.get(a);
        }
        return Integer.MAX_VALUE;
    }

    public int distToClosestVisited(Set<Node> visited) {
        int closestDist = Integer.MAX_VALUE;
        for (Node n : getNeighbours()) {
            if (visited.contains(n)) {
                int dist = distanceToNeighbour(n);
                if (dist < closestDist) {
                    closestDist = dist;
                }
            }
        }
        return closestDist;
    }

    public Set<Node> getNeighbours() {
        return neighbours.keySet();
    }

    @Override
    public String toString() {
        return "(" + name + ")";
    }
}

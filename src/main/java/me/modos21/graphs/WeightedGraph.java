package me.modos21.graphs;

import java.util.*;

public class WeightedGraph implements Graph {

    List<Node> nodes;

    public WeightedGraph() {
        nodes = new ArrayList<>();
    }

    public void addNodes(Node... nodes) {
        this.nodes.addAll(Arrays.asList(nodes));
    }

    @Override
    public void addEdge(Node a, Node b) {

    }

    public void addEdge(Node a, Node b, int len) {
        if (!nodes.contains(a) || !nodes.contains(b)) {
            throw new IllegalArgumentException("One of the given nodes is not in the graph");
        }
        a.addEdge(b, len);
        b.addEdge(a, len);
    }

    @Override
    public void removeEdge(Node a, Node b) {
        if (!nodes.contains(a) || !nodes.contains(b)) {
            throw new IllegalArgumentException("One of the given nodes is not in the graph");
        }
        a.removeEdge(b);
        b.removeEdge(a);
    }

    @Override
    public boolean isConnected() {
        //TODO implement
        return false;
    }

    // 1  function Dijkstra(Graph, source):
    // 2
    // 3      for each vertex v in Graph.Vertices:
    // 4          dist[v] ← INFINITY
    // 5          prev[v] ← UNDEFINED
    // 6          add v to Q
    // 7      dist[source] ← 0
    // 8
    // 9      while Q is not empty:
    //10          u ← vertex in Q with minimum dist[u]
    //11          remove u from Q
    //12
    //13          for each neighbor v of u still in Q:
    //14              alt ← dist[u] + Graph.Edges(u, v)
    //15              if alt < dist[v]:
    //16                  dist[v] ← alt
    //17                  prev[v] ← u
    //18
    //19      return dist[], prev[]


    /**
     * Calculates the shortest distance from node a to node b using Dijkstra's algorithm
     * @param start the starting node
     * @param end the ending node
     * @return the shortest path from a to b, or -1 if a and b are not connected
     * @throws IllegalArgumentException if at least one of the nodes is not in the graph
     */
    public int shortestDistance(Node start, Node end) {
        if (!nodes.contains(start) || !nodes.contains(end)) {
            throw new IllegalArgumentException("Either start or end are not in the graph");
        }
        if (start == end) {
            return 0;
        }

        Set<Node> toVisit = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> prev = new HashMap<>();

        Map<Node, Integer> distances = new HashMap<>();
        for (Node n : this.nodes) {
            toVisit.add(n);
            distances.put(n, Integer.MAX_VALUE);
            prev.put(n, null);
        }

        distances.put(start, 0);
        visited.add(start);

        while (!toVisit.isEmpty()) {
            Node curr = getClosestRemainingNode(start, toVisit, visited);
            visited.add(curr);
            toVisit.remove(curr);

            for (Node n : curr.getNeighbours()) {
                if (toVisit.contains(n)) {
                    int alt = distances.get(curr) + curr.distanceToNeighbour(n);
                    if (alt < distances.get(n)) {
                        distances.put(n, alt);
                        prev.put(n, curr);
                    }
                }
            }
        }

        System.out.println("Path of shortest distance:");
        Node curr = end;
        NodeList path = new NodeList();
        while (curr != start) {
            path.prepend(curr);
            curr = prev.get(curr);
        }
        path.prepend(start);

        System.out.printf("Path of shortest distance from %s to %s : %s\n", start, end, path);
        return distances.get(end);
    }

    Node getClosestRemainingNode(Node src, Set<Node> toVisit, Set<Node> visited) {
        if (toVisit.contains(src)) {
            return src;
        }

        Node closest = null;
        int closestDist = Integer.MAX_VALUE;
        for (Node n : toVisit) {
            int dist = n.distToClosestVisited(visited);
            if (dist < closestDist) {
                closestDist = dist;
                closest = n;
            }
        }
        return closest;
    }
}

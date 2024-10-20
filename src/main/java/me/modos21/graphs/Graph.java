package me.modos21.graphs;

public interface Graph {

    /**
     * Adds an edge between nodes a and b
     * @param a the first node
     * @param b the second node
     * @throws IllegalArgumentException if at least one of the nodes is not in the graph
     */
    void addEdge(Node a, Node b);

    /**
     * Removes an edge between nodes a and b
     * @param a the first node
     * @param b the second node
     * @throws IllegalArgumentException if at least one of the nodes is not in the graph
     */
    void removeEdge(Node a, Node b);

    /**
     * Checks if the graph is connected. A graph is connected, when every node can be reached from every other node.
     * An empty graph and a graph with only one node both count as connected
     * @return true if the graph is connected, false if not
     */
    boolean isConnected();
}

package me.modos21.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    static WeightedGraph graph = new WeightedGraph();
    static Node a = new Node('a');
    static Node b = new Node('b');
    static Node c = new Node('c');
    static Node d = new Node('d');
    static Node e = new Node('e');
    static Node f = new Node('f');
    static Node g = new Node('g');
    static Node h = new Node('h');
    static Node i = new Node('i');

    static {
        graph.addNodes(a, b, c, d, e, f, g, h, i);
        graph.addEdge(a, b, 2);
        graph.addEdge(a, c, 3);
        graph.addEdge(a, f, 4);
        graph.addEdge(b, c, 6);
        graph.addEdge(b, d, 6);
        graph.addEdge(b, e, 7);
        graph.addEdge(b, g, 1);
        graph.addEdge(c, f, 2);
        graph.addEdge(c, h, 2);
        graph.addEdge(d, e, 4);
        graph.addEdge(d, f, 3);
        graph.addEdge(d, h, 1);
        graph.addEdge(e, g, 5);
        graph.addEdge(f, h, 3);
        graph.addEdge(f, i, 1);
        graph.addEdge(g, h, 2);
        graph.addEdge(g, i, 5);
    }

    @Test
    public void test_Dijkstra_from_a() {
        assertEquals(2, graph.shortestDistance(a, b));
        assertEquals(3, graph.shortestDistance(a, c));
        assertEquals(6, graph.shortestDistance(a, d));
        assertEquals(8, graph.shortestDistance(a, e));
        assertEquals(4, graph.shortestDistance(a, f));
        assertEquals(3, graph.shortestDistance(a, g));
        assertEquals(5, graph.shortestDistance(a, h));
        assertEquals(5, graph.shortestDistance(a, i));
    }

    @Test
    public void test_Dijkstra_from_b() {
        assertEquals(2, graph.shortestDistance(b, a));
        assertEquals(5, graph.shortestDistance(b, c));
        assertEquals(4, graph.shortestDistance(b, d), "Failed in b - d");
        assertEquals(6, graph.shortestDistance(b, e), "Failed in b - e");
        assertEquals(6, graph.shortestDistance(b, f), "Failed in b - f");
        assertEquals(1, graph.shortestDistance(b, g));
        assertEquals(3, graph.shortestDistance(b, h));
        assertEquals(6, graph.shortestDistance(b, i), "Failed in b - i");
    }
}

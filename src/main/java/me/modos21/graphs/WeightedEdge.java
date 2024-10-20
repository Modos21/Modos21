package me.modos21.graphs;

public class WeightedEdge extends Edge {

    final int length;

    public WeightedEdge(Node to, int length) {
        super(to);
        this.length = length;
    }
}

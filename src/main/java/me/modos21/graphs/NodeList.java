package me.modos21.graphs;

public class NodeList {

    NodeListElement head;

    public NodeList() {}

    public void prepend(Node n) {
        if (head == null) {
            head = new NodeListElement(n);
        }
        else head = head.prepend(n);
    }

    static class NodeListElement {
        Node node;

        NodeListElement next;

        public NodeListElement(Node node, NodeListElement next) {
            this.next = next;
            this.node = node;
        }

        public NodeListElement(Node node) {
            this(node, null);
        }

        public NodeListElement prepend (Node node){
            return new NodeListElement(node, this);
        }

            @Override
        public String toString () {
            return node + ((next != null) ? " -> " + next : "");
        }
    }

    @Override
    public String toString() {
        return head.toString();
    }
}

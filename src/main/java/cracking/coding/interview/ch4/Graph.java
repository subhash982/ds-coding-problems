package cracking.coding.interview.ch4;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    public List <GraphNode> nodes;

    public List <GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(List <GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void addNode(GraphNode node) {
        if (nodes == null) {
            nodes = new LinkedList <>();
        }

        nodes.add(node);
    }
}

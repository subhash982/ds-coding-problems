package cracking.coding.interview.ch4;

import java.util.LinkedList;

/**
 * This problem can be sole by using graph traversal algorith BFS or DFC
 */
public class RouteBetweenNodes {

    boolean search(Graph graph, GraphNode start, GraphNode end) {
        if (start == end) {
            return true;
        }

        LinkedList <GraphNode> queue = new LinkedList <>();
        //Set All the node as unvisited
        for (GraphNode node : graph.nodes) {
            node.state = GraphNode.State.Unvisited;
        }
        queue.add(start);
        start.state = GraphNode.State.Visiting;
        GraphNode unvisited;
        while (!queue.isEmpty()) {
            unvisited = queue.removeFirst();
            if (unvisited != null) {
                for (GraphNode visitingNode : unvisited.getAdjacents()) {
                    if (visitingNode.state == GraphNode.State.Unvisited) {
                        if (visitingNode == end) {
                            return true;
                        } else {
                            visitingNode.state = GraphNode.State.Visiting;
                            queue.add(visitingNode);
                        }

                    }

                }

                unvisited.state= GraphNode.State.Visited;
            }
        }

        return false;

    }
}

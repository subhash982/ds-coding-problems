package cracking.coding.interview.ch4;

import java.util.List;

public class GraphNode {
    enum State{Unvisited, Visited,Visiting}
    public String name;
    public State state;
    public List<GraphNode> adjacents;


    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public List<GraphNode> getAdjacents() {
        return adjacents;
    }
}

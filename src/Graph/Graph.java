package Graph;

import java.util.List;

// representation of a graph
public interface Graph {
    boolean hasEdge(int n1, int n2);
    int getEdge(int n1, int n2);
    void addEdge(int n1, int n2, int cost);
    void removeEdge(int n1, int n2);
    int size();
    List<Integer> getNeighbors(int node);
}

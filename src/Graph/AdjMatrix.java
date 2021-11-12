package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Adjacency matrix representation of a graph.
 * If there is an edge of cost c between nodes n1, n2:
 *      graph[n1][n2] = c and graph[n2][n1] = c
 *      NOTE, if the graph is unweighted, c = 1
 * If there is no edge between n1 and n2:
 *      graph[n1][n2] = 0
 * Time Complexity of methods:
 *      Add/remove edge: O(1)
 *      Querying: O(1)
 * Space complexity: O(V^2)
 */
public class AdjMatrix implements Graph{
    private int[][] graph;
    private int numNodes;
    private boolean isUndirected;

    public AdjMatrix(int nodes, boolean isUndirected) {
        numNodes = nodes;
        graph = new int[nodes][nodes];
        this.isUndirected = isUndirected;
    }

    public boolean hasEdge(int node1, int node2) {
        return graph[node1][node2] != 0;
    }

    public int getEdge(int node1, int node2) {
        return graph[node1][node2];
    }

    public void addEdge(int node1, int node2, int cost) {
        graph[node1][node2] = cost;
        if (isUndirected) {
            graph[node2][node1] = cost;
        }
    }

    public void removeEdge(int node1, int node2) {
        graph[node1][node2] = 0;
        if (isUndirected) {
            graph[node2][node1] = 0;
        }
    }

    public int size() {
        return numNodes;
    }

    public List<Integer> getNeighbors(int n) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            if (graph[n][i] != 0) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }
}

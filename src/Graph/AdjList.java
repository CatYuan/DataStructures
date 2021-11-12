package Graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Adjacency list representation of a graph.
 * The edge weight between nodes n1 and n2 are stored
 *      in the list at graph.get(n1) as a Pair, (n2, weight)
 *      in the list at graph.get(n2) as a Pair, (n1, weight)
 * Time Complexity of methods:
 *      Add/remove edge: O(1)
 *      Querying: O(V)
 * Space complexity: O(V+E)
 */
public class AdjList implements Graph{
    private ArrayList<ArrayList<Pair<Integer, Integer>>> graph;
    private int numNodes;
    private boolean isUndirected;

    public AdjList(int nodes, boolean isUndirected) {
        this.numNodes = nodes;
        this.isUndirected = isUndirected;
        graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public boolean hasEdge(int n1, int n2) {
        ArrayList<Pair<Integer, Integer>> edges = graph.get(n1);
        for (Pair<Integer, Integer> pair : edges) {
            Integer node = pair.getKey();
            if (node == n2) {
                return true;
            }
        }
        return false;
    }

    public int getEdge(int n1, int n2) {
        ArrayList<Pair<Integer, Integer>> edges = graph.get(n1);
        for (Pair<Integer, Integer> pair : edges) {
            Integer node = pair.getKey();
            Integer weight = pair.getValue();
            if (node == n2) {
                return weight;
            }
        }
        return 0;
    }

    public void addEdge(int n1, int n2, int cost) {
        graph.get(n1).add(new Pair<> (n2, cost));
        if (isUndirected) {
            graph.get(n2).add(new Pair<>(n1, cost));
        }
    }

    public void removeEdge(int n1, int n2) {
        ArrayList<Pair<Integer, Integer>> edges1 = graph.get(n1);
        ArrayList<Pair<Integer, Integer>> edges2 = graph.get(n2);
        for (Pair<Integer, Integer> pair : edges1) {
            if (pair.getKey() == n2) {
                edges1.remove(pair);
                break;
            }
        }
        if (isUndirected) {
            for (Pair<Integer, Integer> pair : edges2) {
                if (pair.getKey() == n1) {
                    edges2.remove(pair);
                    break;
                }
            }
        }
    }

    public int size() {
        return numNodes;
    }

    public List<Integer> getNeighbors(int n) {
        List<Integer> neighbors = new ArrayList<>();
        for (Pair<Integer, Integer> pair : graph.get(n)) {
            neighbors.add(pair.getKey());
        }
        return neighbors;
    }
}

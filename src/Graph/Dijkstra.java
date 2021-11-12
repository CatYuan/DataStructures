package Graph;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// finds shortest path distance between a specified node and all other nodes
// in the graph
public class Dijkstra {

    /**
     * Time complexity: O(ElogV)
     * Space complexity: O(V)
     * Uses priority queue of pairs (node, distance)
     * @param g - graph
     * @param source - node to start from
     * @return - list of shortest distances from source
     */
    public List<Integer> pqDijkstra(Graph g, int source) {
        // setup
        Integer[] out = new Integer[g.size()];
        Comparator <Pair<Integer, Integer>> comp = new Comparator<Pair<Integer, Integer>>() {
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return Integer.compare(p1.getValue(), p2.getValue());
            }
        };
        PriorityQueue<Pair<Integer, Integer>> distances = new PriorityQueue(g.size(), comp);
        for (int i = 0; i < g.size(); i++) {
            if (i == source) {
                distances.offer(new Pair<>(i, 0));
                out[i] = 0;
            } else {
                distances.offer(new Pair<>(i, Integer.MAX_VALUE));
                out[i] = Integer.MAX_VALUE;
            }
        }
        // running dijkstra
        for (int i = 0; i < g.size(); i++) {
            Pair<Integer, Integer> minPair = distances.poll();
            int minDistNode = minPair.getKey();
            int dist = minPair.getValue();
            // visit neighbors
            for (int neighbor : g.getNeighbors(minDistNode)) {
                if (dist + g.getEdge(minDistNode, neighbor) < out[neighbor]) {
                    int newDist = dist + g.getEdge(minDistNode, neighbor);
                    int oldDist = out[neighbor];
                    out[neighbor] = newDist;
                    if (distances.remove(new Pair<>(neighbor, oldDist))) {
                        distances.add(new Pair<>(neighbor, newDist));
                    }
                }
            }
        }
        return Arrays.asList(out);
    }

    /**
     * time complexity: O(V^2)
     * space complexity: O(V)
     * @param g
     * @param source
     * @return
     */
    public List<Integer> dijkstra(Graph g, int source) {
        // setup
        boolean[] visited = new boolean[g.size()];
        Integer[] distances = new Integer[g.size()];
        for (int i = 0; i < g.size(); i++) {
            if (i == source) {
                distances[i] = 0;
            } else {
                distances[i] = Integer.MAX_VALUE;
            }
            visited[i] = false;
        }
        // running dijkstra
        for (int i = 0; i < g.size(); i++) {
            int minDistNode = getMinDistNode(distances, visited);
            int dist = distances[minDistNode];
            visited[minDistNode] = true;
            // visit neighbors
            for (int neighbor : g.getNeighbors(minDistNode)) {
                if (dist + g.getEdge(minDistNode, neighbor) < distances[neighbor]) {
                    distances[neighbor] = dist + g.getEdge(minDistNode, neighbor);
                }
            }
        }
        return Arrays.asList(distances);
    }

    private int getMinDistNode(Integer[] dists, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < dists.length; i++) {
            if (dists[i] <= min && !visited[i]) {
                minIndex = i;
                min = dists[i];
            }
        }
        return minIndex;
    }
 }

package Graph;

import java.util.ArrayList;
import java.util.List;

public class AStar {

    /**
     * time complexity: O(VE)
     *      using priority queue leads to time complexity of: O(ElogV)
     *      b/c priority queue runs getMinNode in log(V)
     * space complexity: O(V)
     * let f = distances + heuristic
     * @param g - graph
     * @param src - src node
     * @param dest - destination node
     * @return the path from src to dest
     */
    public int[] astar(Graph g, int src, int dest, String heuristic) {
        // setup
        int[] distances = new int[g.size()];
        int[] fs = new int[g.size()];
        int[] parents = new int[g.size()];
        boolean[] visited = new boolean[g.size()];
        for (int i = 0; i < fs.length; i++) {
            distances[i] = Integer.MAX_VALUE;
            fs[i] = Integer.MAX_VALUE;
            visited[i] = false;
            parents[i] = -1;
        }
        fs[src] = 0;
        distances[src] = 0;
        // run astar
        for (int i = 0; i < fs.length; i++) {
            int currNode = getMinNode(fs, visited);
            visited[currNode] = true;
            if (currNode == dest) { break; }
            for (int neighbor : g.getNeighbors(currNode)) {
                int newDist = g.getEdge(currNode, neighbor) + distances[currNode];
                if (newDist < distances[neighbor]) {
                    distances[neighbor] = newDist;
                    fs[neighbor] = newDist + getHeuristic(heuristic, g, neighbor, dest);
                    parents[neighbor] = currNode;
                }
            }
        }
        // cleanup
        return parents;
    }

    private int getMinNode(int[] fs, boolean[] visited) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < fs.length; i++) {
            if (!visited[i] && fs[i] < min) {
                min = fs[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int getHeuristic(String heuristic, Graph g, int node, int dest) {
        if (heuristic == null) { return 0; }
        return -1;
    }

    public List<Integer> getPathFromParents(int[] parents, int dest) {
        List<Integer> out = new ArrayList<>();
        int currNode = dest;
        while (parents[currNode] != -1) {
            out.add(0, currNode);
            currNode = parents[currNode];
        }
        out.add(0, currNode);
        return out;
    }
}

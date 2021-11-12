package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// assume that the start node is a valid node in the grpah
// assume the graph is connected
public class BreadthAndDepth {

    public List<Integer> bfs(Graph g, int start) {
        List<Integer> out = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[g.size()];
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            out.add(node);
            List<Integer> neighbors = g.getNeighbors(node);
            for (int neighbor : neighbors) {
                if (visited[neighbor]) { continue; }
                visited[neighbor] = true;
                q.add(neighbor);
            }
        }
        return out;
    }

    public List<Integer> dfs(Graph g, int start) {
        List<Integer> out = new ArrayList<>();
        boolean[] visited = new boolean[g.size()];
        return _dfs(g, start, visited, out);
    }

    private List<Integer> _dfs(Graph g, int start, boolean[] visited, List<Integer> out) {
        visited[start] = true;
        out.add(start);
        for (int neighbor : g.getNeighbors(start)) {
            if (visited[neighbor]) { continue; }
            visited[neighbor] = true;
            _dfs(g, neighbor, visited, out);
        }
        return out;
    }
}

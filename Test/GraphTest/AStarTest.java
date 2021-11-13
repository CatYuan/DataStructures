package GraphTest;

import Graph.Graph;
import Graph.AdjList;
import Graph.AStar;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AStarTest {
    // test using dijkstra heuristic = null
    AStar a = new AStar();

    @Test
    public void undirectedTest() {
        Graph g = new AdjList(9, true);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(2, 8, 14);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 9);
        g.addEdge(7, 6, 9);
        g.addEdge(6, 5, 11);
        g.addEdge(5, 4, 21);

        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        int[] parents = a.astar(g, 0, 4, null);
        List<Integer> actual = a.getPathFromParents(parents, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void directedTest() {
        Graph g = new AdjList(4, false);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 6);
        g.addEdge(2, 3, 3);

        List<Integer> expected = Arrays.asList(0, 1, 2);
        int[] parents = a.astar(g, 0, 2, null);
        List<Integer> actual = a.getPathFromParents(parents, 2);
        Assert.assertEquals(expected, actual);
    }
}

package GraphTest;

import Graph.Graph;
import Graph.AdjMatrix;
import Graph.BreadthAndDepth;
import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class BreadthAndDepthTest {
    BreadthAndDepth mySearch = new BreadthAndDepth();

    @Test
    public void basicBFSTest() {
        Graph g = new AdjMatrix(7, true);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 1);
        g.addEdge(3, 5, 1);
        g.addEdge(2, 5, 1);
        g.addEdge(2, 4, 1);
        g.addEdge(4, 5, 1);
        g.addEdge(4, 6, 1);
        g.addEdge(5, 6, 1);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assert.assertEquals(expected, mySearch.bfs(g, 1));
    }

    @Test
    public void basicDFSTest() {
        Graph g = new AdjMatrix(4, false);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 0, 1);
        g.addEdge(3, 3, 1);
        List<Integer> expected = Arrays.asList(2, 0, 1, 3);
        Assert.assertEquals(expected, mySearch.dfs(g, 2));
    }
}

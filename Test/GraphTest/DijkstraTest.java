package GraphTest;

import Graph.Graph;
import Graph.AdjMatrix;
import Graph.Dijkstra;
import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class DijkstraTest {
    Dijkstra d = new Dijkstra();

    @Test
    public void undirectedTest() {
        Graph g = new AdjMatrix(9, true);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        List<Integer> expected = Arrays.asList(0, 4, 12, 19, 21, 11, 9, 8, 14);
        Assert.assertEquals(expected, d.dijkstra(g, 0));
    }

    @Test
    public void directedTest() {
        Graph g = new AdjMatrix(4, false);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 6);
        g.addEdge(2, 3, 3);

        List<Integer> expected = Arrays.asList(0, 1, 3, 6);
        Assert.assertEquals(expected, d.dijkstra(g, 0));
    }
}

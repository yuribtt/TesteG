import org.graphast.model.Graph;
import org.graphast.query.route.shortestpath.AbstractShortestPathService;
import org.graphast.query.route.shortestpath.dijkstra.DijkstraConstantWeight;
import org.graphast.query.route.shortestpath.model.Path;

/**
 * Created by yuri on 18/04/17.
 */
public class QueryExample {

    public static void main(String[] agrs) {

        Graph graph = new GenerateGraphExample().monacoExample();

        AbstractShortestPathService service = new DijkstraConstantWeight(graph);

        Long source = graph.getNodeId(43.740174,7.424376);
        Long target = graph.getNodeId(43.735554,7.416147);
        Path shortestPath = service.shortestPath(source, target);

    }

}

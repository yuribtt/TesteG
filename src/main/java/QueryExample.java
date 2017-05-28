import org.graphast.model.Graph;
import org.graphast.query.route.shortestpath.AbstractShortestPathService;
import org.graphast.query.route.shortestpath.dijkstra.DijkstraConstantWeight;
import org.graphast.query.route.shortestpath.model.Path;

/**
 * Created by yuri on 18/04/17.
 */
public class QueryExample {

    public static void main(String[] agrs) {

    	/*instanciando o grafo pelo método criando na classe GenerateGraphExample
    	criada anteriormente no exemplo*/
        Graph graph = new GenerateGraphExample().monacoExample();

        /*instanciando um serviço, no caso de menor caminho, mais precisamente o Dijkstra de pesos constantes.
        basta passar o grafo como parâmetro para omstanciar o serviço*/
        AbstractShortestPathService service = new DijkstraConstantWeight(graph);

        /*nesta parte são escolhidos dois nós do grafo de acordo com as coordenadas passadas,
        então chama-se o método para encontrar o menor caminho entre os dois*/
        Long source = graph.getNodeId(43.740174,7.424376);
        Long target = graph.getNodeId(43.735554,7.416147);
        Path shortestPath = service.shortestPath(source, target);

    }

}

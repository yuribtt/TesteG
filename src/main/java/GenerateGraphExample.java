import org.graphast.config.Configuration;
import org.graphast.importer.CostGenerator;
import org.graphast.importer.OSMImporterImpl;
import org.graphast.importer.POIImporter;
import org.graphast.model.GraphBounds;

/**
 * Created by yuri on 18/04/17.
 */
public class GenerateGraphExample {

    public GraphBounds monacoExample() {
    	
    	//pegando o caminho para o mapa (.osm.pbf)
        String osmFile = this.getClass().getResource("/monaco-150112.osm.pbf").getPath();
        //apontando o diretório de armazenamento do grafo
        String graphastMonacoDir = Configuration.USER_HOME + "/graphast/test/monaco";

        /*a clase OSMImporter é instanciada com os diretorios do mapa e de onde queremos guardar,
        o método .execute() transforma esse mapa em um GraphBounds*/
        GraphBounds graph = new OSMImporterImpl(osmFile, graphastMonacoDir).execute();

        /*caso queira importar pontos de interesse para o grafo, podemos chamar o método abaixo passando
         o grafo e o diretório do arquivo contendo os pontos de interesse(o arquivo precisa ser .scv)*/
        POIImporter.importPoIList(graph, "src/main/resources/monaco-latest.csv");

        /*para gerar os custos do grafo, basta utilizar o método abaixo passando o grafo como parâmetro*/
        CostGenerator.generateAllSyntheticEdgesCosts(graph);

        return graph;
    }
}

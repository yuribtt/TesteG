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
        String osmFile = this.getClass().getResource("/monaco-150112.osm.pbf").getPath();
        String graphastMonacoDir = Configuration.USER_HOME + "/graphast/test/monaco";

        GraphBounds graph = new OSMImporterImpl(osmFile, graphastMonacoDir).execute();

        POIImporter.importPoIList(graph, "src/main/resources/monaco-latest.csv");

        CostGenerator.generateAllSyntheticEdgesCosts(graph);

        return graph;
    }
}

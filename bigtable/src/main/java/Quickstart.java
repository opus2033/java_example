package bigtable.src.main.java;
import com.google.cloud.bigtable.hbase.BigtableConfiguration;
import java.io.IOException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class Quickstart {
    public static void main(String [] args){
        String projectId = args[0];  // my-gcp-project-id
    String instanceId = args[1]; // my-bigtable-instance-id
    String tableId = args[2];    // my-bigtable-table-id

    // Create a connection to the Cloud Bigtable instance.
    // Use try-with-resources to make sure the connection is closed correctly
    try (Connection connection = BigtableConfiguration.connect(projectId, instanceId)) {

      System.out.println("--- Connection established with Bigtable Instance ---");
      // Create a connection to the table that already exists
      // Use try-with-resources to make sure the connection to the table is closed correctly
      try (Table table = connection.getTable(TableName.valueOf(tableId))) {

        // Read a row
        String rowKey = "r1";
        System.out.printf("--- Reading for row-key: %s for provided table: %s ---\n",
            rowKey, tableId);

        // Retrieve the result
        Result result = table.get(new Get(Bytes.toBytes(rowKey)));

        // Convert row data to string
        String rowValue = Bytes.toString(result.value());

        System.out.printf("Scanned value for Row r1: %s \n", rowValue);

        System.out.println(" --- Finished reading row --- ");

      }  catch (IOException e) {
        // handle exception while connecting to a table
        throw e;
      }
    } catch (IOException e) {
    System.err.println("Exception while running quickstart: " + e.getMessage());
    e.printStackTrace();
   }
}
}

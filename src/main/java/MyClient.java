import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import java.io.IOException;

public class MyClient {

    public static void main(String args[]) throws IOException {

        final String TABLE_NAME = "myTable_" + System.currentTimeMillis();
        final String CF_NAME = "myColumnFamily";

        //Create the table
        HBaseAdmin myAdmin = new HBaseAdmin(new Configuration());
        HTableDescriptor htd = new HTableDescriptor(TABLE_NAME);
        htd.addFamily(new HColumnDescriptor(CF_NAME));
        myAdmin.createTable(htd);

        //List the table
        for(TableName t : myAdmin.listTableNames()) {
            System.out.println("Table: " + t.getNameAsString());
        }
    }
}
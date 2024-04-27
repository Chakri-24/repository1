package com.datasetcompare;

import java.util.ArrayList;
import java.util.List;
import org.apache.spark.sql.*;

import static org.apache.spark.sql.functions.*;

public class DataSetCompareMain {

    public static void main(String[] args) {
        System.out.println("=======start=======");
        SparkSession sparkSession = SparkSession.builder().master("local[*]").getOrCreate();

        Dataset<Row> df1 = sparkSession.read().option("header", "true").csv("src/main/resources/input.csv");
        Dataset<Row> df2 = sparkSession.read().option("header", "true").csv("src/main/resources/input_new.csv");
        df1.show();

        df2.show();

        String[] columns = df1.columns();

        Dataset<Row> joined = prefix(df1, "_1").join(prefix(df2, "_2"),
                col("id_1").eqNullSafe(col("id_2")), "full_outer");


        List<Column> diffs = new ArrayList<>();
        for( String column: columns) {
            diffs.add(lit(column));
            diffs.add(when(col(column + "_1").eqNullSafe(col(column + "_2")), null)
                    .otherwise(concat_ws("/", col(column + "_1"), col(column + "_2"))));
        }

        joined=joined.withColumn("differences", map(diffs.toArray(new Column[]{})))
                .withColumn("differences", map_filter(col("differences"), (k, v) -> not(v.isNull())))
                .select("id_1", "differences")
                .filter(size(col("differences")).gt(0));
        //.show(false);
        joined.show(false);
        joined.printSchema();
        //joined.select(functions.explode(col("differences")), col("id_1"))

        //.withColumn("mapkeys", functions.map_keys(col("differences")))
        //.withColumn("mapvalues",functions.map_values(col("differences")))
        //.show(false);
    }

    private static Dataset<Row> prefix(Dataset<Row> df, String prefix) {
        for(String col: df.columns()) df = df.withColumnRenamed(col, col + prefix);
        return df;
    }
}
import org.apache.spark.sql.SparkSession

object AverageOfItems {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("AverageOfItems")
      .master("local[*]")
      .getOrCreate()
    
    // Read CSV into DataFrame
    val itemsDF = spark.read.option("header", "false").csv("items.csv").toDF("value")
    
    // Convert column to numeric type and compute average
    val average = itemsDF.select($"value".cast("int")).agg(avg("value")).first().getDouble(0)
    
    println(s"Average of items: $average")
    
    spark.stop()
  }
}


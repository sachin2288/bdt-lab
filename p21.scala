import org.apache.spark.sql.SparkSession

object HashPartitioning {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("HashPartitioning")
      .master("local[*]")
      .getOrCreate()
    
    // Sample data for Employee table
    val data = Seq(
      (1, "IT", "Developer"), (2, "HR", "Manager"), (3, "IT", "Engineer"),
      (4, "Finance", "Analyst"), (5, "IT", "Tester"), (6, "HR", "Assistant")
    )
    
    // Create DataFrame
    import spark.implicits._
    val employeeDF = data.toDF("EmpID", "Dept", "EmpDesg")
    
    // Hash partition by Dept into 4 partitions
    val partitionedDF = employeeDF.repartition(4, $"Dept")
    
    // Show partitions
    partitionedDF.foreachPartition(iter => {
      println("Partition contents:")
      iter.foreach(println)
      println("---")
    })
    
    spark.stop()
  }
}


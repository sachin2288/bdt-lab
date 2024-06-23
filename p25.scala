import org.apache.spark.{SparkConf, SparkContext}

object RDDPartitionContent {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDDPartitionContent").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    // Sample data for ItemRDD
    val data = List(("Ball", 10), ("Ribbon", 50), ("Box", 20), ("Pen", 5), ("Book", 8), ("Dairy", 4), ("Pin", 20))
    
    // Create RDD with specified partitioning
    val ItemRDD = sc.parallelize(data)
      .partitionBy(new org.apache.spark.HashPartitioner(3)) // Example partitioning
    
    // Get partitions
    val partitions = ItemRDD.glom().collect()
    
    // Display content of each partition separately
    partitions.zipWithIndex.foreach { case (partition, index) =>
      println(s"Partition $index:")
      partition.foreach(println)
      println("---")
    }
    
    sc.stop()
  }
}


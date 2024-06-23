import org.apache.spark.{SparkConf, SparkContext}

object RDDPartitionAnalysis {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDDPartitionAnalysis").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    // Sample data for ItemRDD
    val data = List(("Ball", 10), ("Ribbon", 50), ("Box", 20), ("Pen", 5), ("Book", 8), ("Dairy", 4), ("Pin", 20))
    
    // Create RDD with 3 partitions
    val ItemRDD = sc.parallelize(data, 3)
    
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


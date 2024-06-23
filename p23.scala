import org.apache.spark.{SparkConf, SparkContext}

object RDDPartitionAndMap {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDDPartitionAndMap").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    // Sample collection
    val data = Array(11, 34, 45, 67, 3, 4, 90)
    
    // Create RDD with 3 partitions
    val rdd = sc.parallelize(data, 3)
    
    // Print content of each partition with index
    val mappedRDD = rdd.mapPartitionsWithIndex((index, iter) => {
      iter.map(num => s"Partition $index: $num")
    })
    
    // Collect and print results
    mappedRDD.collect().foreach(println)
    
    sc.stop()
  }
}


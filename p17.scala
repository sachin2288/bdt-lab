import org.apache.spark.{SparkConf, SparkContext}

object WordCountPairRDD {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCountPairRDD").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    // Read text file into an RDD of lines
    val lines = sc.textFile("text.txt")
    
    // Split each line into words, create PairRDD with (word, 1)
    val wordPairs = lines.flatMap(_.split("\\s+")).map(word => (word, 1))
    
    // Count occurrences of each word
    val wordCounts = wordPairs.reduceByKey(_ + _)
    
    // Save result to a file
    wordCounts.saveAsTextFile("output")
    
    // Print result
    wordCounts.collect().foreach(println)
    
    sc.stop()
  }
}


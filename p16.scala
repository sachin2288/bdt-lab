import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    // Read text file into an RDD of lines
    val lines = sc.textFile("text.txt")
    
    // Split each line into words, flatten into single RDD of words
    val words = lines.flatMap(_.split("\\s+"))
    
    // Count occurrences of each word
    val wordCounts = words.map(word => (word, 1)).reduceByKey(_ + _)
    
    // Filter words that appear more than 4 times
    val frequentWords = wordCounts.filter(_._2 > 4)
    
    // Save result to a file
    frequentWords.saveAsTextFile("output")
    
    // Print result
    frequentWords.collect().foreach(println)
    
    sc.stop()
  }
}


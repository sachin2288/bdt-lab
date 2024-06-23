import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object TopTweeters {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("TopTweeters")
      .master("local[*]")
      .getOrCreate()
    
    // Load JSON dataset
    val tweets = spark.read.json("reduced-tweets.json")
    
    // Group by user and count tweets, then sort and take top 10
    val topTweeters = tweets.groupBy("user").count().orderBy(desc("count")).limit(10)
    
    // Show top 10 tweeters
    topTweeters.show()
    
    spark.stop()
  }
}


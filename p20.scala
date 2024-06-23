import org.apache.spark.{SparkConf, SparkContext}

object AverageMarks {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("AverageMarks").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    // Sample input format: Array( ("Joe", "Maths", 83), ("Joe", "Physics", 74), ...)
    val marks = sc.parallelize(Array(
      ("Joe", "Maths", 83), ("Joe", "Physics", 74), ("Joe", "Chemistry", 91), ("Joe", "Biology", 82),
      ("Nik", "Maths", 69), ("Nik", "Physics", 62), ("Nik", "Chemistry", 97), ("Nik", "Biology", 80)
    ))
    
    // Combine by key to calculate sum and count for each student
    val sumCount = marks.combineByKey(
      (score: Int) => (score, 1),
      (acc: (Int, Int), score: Int) => (acc._1 + score, acc._2 + 1),
      (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2)
    )
    
    // Calculate average marks
    val averageMarks = sumCount.mapValues { case (sum, count) => sum.toDouble / count }
    
    // Print result
    averageMarks.collect().foreach(println)
    
    sc.stop()
  }
}


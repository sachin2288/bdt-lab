import org.apache.spark.sql.SparkSession

object SparkFoldAggregate {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.appName("Fold and Aggregate").getOrCreate()
    val sc = spark.sparkContext

    val items = sc.parallelize(Seq(("Pen", 20), ("Pencil", 10), ("Eraser", 7), ("Book", 25), ("Sheet", 15)))

    // Using fold
    val foldResult = items.mapValues(_ + 100).fold(("", 0))((acc, item) => ("", acc._2 + item._2))
    println(s"Result of fold: $foldResult")

    // Using aggregate
    val zeroValue = 0
    val seqOp = (acc: Int, value: (String, Int)) => acc + value._2 + 100
    val combOp = (acc1: Int, acc2: Int) => acc1 + acc2
    val aggregateResult = items.aggregate(zeroValue)(seqOp, combOp)
    println(s"Result of aggregate: $aggregateResult")

    spark.stop()
  }
}


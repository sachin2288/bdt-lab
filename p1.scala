object BubbleSort {
  def bubbleSort(arr: Array[Int]): Array[Int] = {
    val n = arr.length
    for (i <- 0 until n - 1) {
      for (j <- 0 until n - 1 - i) {
        if (arr(j) > arr(j + 1)) {
          val temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
        }
      }
    }
    arr
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(64, 34, 25, 12, 22, 11, 90)
    println("Original array: " + arr.mkString(", "))
    val sortedArr = bubbleSort(arr)
    println("Sorted array: " + sortedArr.mkString(", "))
  }
}


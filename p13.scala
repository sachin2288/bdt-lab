object BinarySearch {
  def binarySearch(arr: Array[Int], target: Int, low: Int, high: Int): Boolean = {
    if (low > high) false
    else {
      val mid = (low + high) / 2
      if (arr(mid) == target) true
      else if (arr(mid) > target) binarySearch(arr, target, low, mid - 1)
      else binarySearch(arr, target, mid + 1, high)
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val target = 5
    println(s"Is $target in the array? " + binarySearch(arr, target, 0, arr.length - 1))
  }
}


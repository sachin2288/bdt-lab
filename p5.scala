object QuickSort {
  def quickSort(arr: Array[Int]): Array[Int] = {
    def swap(i: Int, j: Int): Unit = {
      val temp = arr(i)
      arr(i) = arr(j)
      arr(j) = temp
    }

    def partition(low: Int, high: Int): Int = {
      val pivot = arr(high)
      var i = low
      for (j <- low until high) {
        if (arr(j) <= pivot) {
          swap(i, j)
          i += 1
        }
      }
      swap(i, high)
      i
    }

    def sort(low: Int, high: Int): Unit = {
      if (low < high) {
        val pi = partition(low, high)
        sort(low, pi - 1)
        sort(pi + 1, high)
      }
    }

    sort(0, arr.length - 1)
    arr
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(10, 7, 8, 9, 1, 5)
    println("Original array: " + arr.mkString(", "))
    val sortedArr = quickSort(arr)
    println("Sorted array: " + sortedArr.mkString(", "))
  }
}


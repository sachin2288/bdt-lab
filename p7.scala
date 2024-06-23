object FunctionalQuickSort {
  def quickSort(list: List[Int]): List[Int] = {
    list match {
      case Nil => Nil
      case pivot :: tail =>
        val (less, greater) = tail.partition(_ < pivot)
        quickSort(less) ::: pivot :: quickSort(greater)
    }
  }

  def main(args: Array[String]): Unit = {
    val list = List(10, 7, 8, 9, 1, 5)
    println("Original list: " + list.mkString(", "))
    val sortedList = quickSort(list)
    println("Sorted list: " + sortedList.mkString(", "))
  }
}


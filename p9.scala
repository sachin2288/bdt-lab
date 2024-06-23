object SearchElement {
  def search(list: List[Int], element: Int): Boolean = {
    list.contains(element)
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val searchElement = 5
    println(s"Is $searchElement in the list? " + search(numbers, searchElement))
  }
}


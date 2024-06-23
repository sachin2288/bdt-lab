object WordLengths {
  def findWordLengths(words: Array[String]): Array[Int] = {
    words.map(_.length)
  }

  def main(args: Array[String]): Unit = {
    val words = Array("hello", "world", "scala", "programming")
    println("Original array: " + words.mkString(", "))
    val lengths = findWordLengths(words)
    println("Lengths of each word: " + lengths.mkString(", "))
  }
}


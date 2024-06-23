object LongestWord {
  def findLongestWord(words: List[String]): (String, Int) = {
    val wordLengths = words.map(word => (word, word.length))
    wordLengths.maxBy(_._2)
  }

  def main(args: Array[String]): Unit = {
    val words = List("games", "television", "rope", "table")
    val (longestWord, length) = findLongestWord(words)
    println(s"The word with the highest length is '$longestWord' with length $length")
  }
}


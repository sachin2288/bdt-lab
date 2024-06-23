object CapitalizeWords {
  def capitalizeWords(sentence: String): String = {
    sentence.split(" ").map(_.capitalize).mkString(" ")
  }

  def main(args: Array[String]): Unit = {
    val sentence = "hello world, welcome to scala programming"
    println("Original sentence: " + sentence)
    val capitalized = capitalizeWords(sentence)
    println("Capitalized sentence: " + capitalized)
  }
}


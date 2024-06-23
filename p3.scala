object BookCountByAuthor {
  def main(args: Array[String]): Unit = {
    val books = Seq(
      ("Dr. Seuss", "How the Grinch Stole Christmas!"),
      ("Jon Stone", "Monsters at the End of This Book"),
      ("Dr. Seuss", "The Lorax"),
      ("Jon Stone", "Big Bird in China"),
      ("Dr. Seuss", "One Fish, Two Fish, Red Fish, Blue Fish")
    )

    val bookCountByAuthor = books.groupBy(_._1).map {
      case (author, books) => (author, books.length)
    }

    println("Number of books published by each author:")
    bookCountByAuthor.foreach { case (author, count) => println(s"$author: $count") }
  }
}


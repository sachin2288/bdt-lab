object ItemCollection {
  def main(args: Array[String]): Unit = {
    var items = Map("Pen" -> 20, "Pencil" -> 10, "Eraser" -> 7, "Book" -> 25, "Sheet" -> 15)

    // i. Display item-name and quantity
    println("Item names and quantities:")
    items.foreach { case (item, quantity) => println(s"$item: $quantity") }

    // ii. Display sum of quantity and total number of items
    val totalQuantity = items.values.sum
    val totalItems = items.size
    println(s"Total quantity: $totalQuantity")
    println(s"Total number of items: $totalItems")

    // iii. Add 3 Books to the collection
    items = items.updated("Book", items("Book") + 3)
    println(s"Updated quantity of Books: ${items("Book")}")

    // iv. Add new item “Board” with quantity 15 to the collection
    items = items + ("Board" -> 15)
    println("Updated items collection:")
    items.foreach { case (item, quantity) => println(s"$item: $quantity") }
  }
}


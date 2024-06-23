object ItemCollection {
  def main(args: Array[String]): Unit = {
    var items = Map("Butter" -> 20, "Bun" -> 10, "Egg" -> 7, "Biscuit" -> 25, "Bread" -> 15)

    // i. Display item-name and quantity
    println("Item names and quantities:")
    items.foreach { case (item, quantity) => println(s"$item: $quantity") }

    // ii. Display sum of quantity and total number of items
    val totalQuantity = items.values.sum
    val totalItems = items.size
    println(s"Total quantity: $totalQuantity")
    println(s"Total number of items: $totalItems")

    // iii. Add 3 Buns to the collection
    items = items.updated("Bun", items("Bun") + 3)
    println(s"Updated quantity of Buns: ${items("Bun")}")

    // iv. Add new item “Cheese” with quantity 12 to the collection
    items = items + ("Cheese" -> 12)
    println("Updated items collection:")
    items.foreach { case (item, quantity) => println(s"$item: $quantity") }
  }
}


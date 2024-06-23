object Factorial {
  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n * factorial(n - 1)
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5)
    println("Factorials of each item in the collection:")
    numbers.foreach(num => println(s"$num! = ${factorial(num)}"))
  }
}


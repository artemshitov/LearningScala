// Experimenting with function literals
// and local functions

val multiTable = (size: Int) => {
  val paddingSize = (size * size).toString.length + 1

  val makeRow = (row: Int) => {
    val makeRowSeq = () =>
      for (col <- 1 to size) yield {
        val prod = (row * col).toString
        val padding = " " * (paddingSize - prod.length)
        padding + prod
      }
    makeRowSeq().mkString
  }

  val table = for (row <- 1 to size) yield {
    makeRow(row)
  }

  table.mkString("\n")
}

println(multiTable(10))

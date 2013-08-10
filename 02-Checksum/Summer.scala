import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]) {
    for (arg <- args)
      println(arg + ": " + ChecksumAccumulator.calculate(arg))
  }
}

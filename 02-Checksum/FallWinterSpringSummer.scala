import ChecksumAccumulator.calculate

object FallWinterSpringSummer extends App {
  for (season <- List("Fall", "Winter", "Spring")) {
    println(season + ": " + calculate(season))
  }
}

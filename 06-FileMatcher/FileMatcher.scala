object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))

  def main(args: Array[String]) {
    if (args.length == 2) args(0) match {
      case "ending" => filesEnding(args(1)) foreach println _
      case "containing" => filesContaining(args(1)) foreach println _
      case "regex" => filesRegex(args(1)) foreach println _
      case _ => println("No valid arguments found")
    }
  }
}

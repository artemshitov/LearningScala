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

  def printFileList(list: Array[java.io.File]) {
    list foreach println _
  }

  def main(args: Array[String]) {
    if (args.length == 2) args(0) match {
      case "ending" => printFileList(filesEnding(args(1)))
      case "containing" => printFileList(filesContaining(args(1)))
      case "regex" => printFileList(filesRegex(args(1)))
      case _ => println("No valid arguments found")
    }
  }
}

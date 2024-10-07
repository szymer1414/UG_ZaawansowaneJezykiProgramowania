object Frame {
  def main(args: Array[String]): Unit = {

    val multiLineString: String =
"""Zdefiniuj funkcje def obramuj(napis: String): String = { ... },
ktora umieszcza lancuch znakow napis w ramce z gwiazdek.
Zaloz, ze argument moze zawierac ("linuksowe") znaki zmiany wiersza ('\n'),
czyli byc tekstem "wielolinijkowym".
Scala umozliwia obliczenie dlugosci dowolnego napisu (napis.length),
a takze "rozbicie" argumentu na tablice linii (napis.split('\n')).
Aby w tablicy znalesc lancuch o maksymalnej dlugosci mozemy wykorzystac tablica.maxBy(s => s.length).
Uzyskana w ten sposob tablice mozemy np. przeksztalcic na tablice linijek w ramce (tablica.map(s => "* " + s + " *")).
""".stripMargin

    val lines: Array[String] = multiLineString.split("\n")
    val longestLine: String = lines.maxBy(_.length)
    val lengthOfLongestLine: Int = longestLine.length

    val modifiedLines: Array[String] = lines.map { line =>
      val trimmedLine = line.trim
      val paddedLine = if (trimmedLine.length < lengthOfLongestLine) {
        trimmedLine + " " * (lengthOfLongestLine - trimmedLine.length) 
      } else {
        trimmedLine
      }

      s"* $paddedLine *"
    }

    val modifiedText: String = modifiedLines.mkString("\n")
    val alignmentLine = "*" * (lengthOfLongestLine + 4)
    println(alignmentLine)
    println(modifiedText)
    println(alignmentLine)
  }
}

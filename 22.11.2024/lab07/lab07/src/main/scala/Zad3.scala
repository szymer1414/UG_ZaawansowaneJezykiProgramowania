@main
def zad3: Unit = {
  val linie = io.Source
    .fromResource("ogniem-i-mieczem.txt")
    .getLines
    .toList
    .mkString(" ")

  def histogram(maks: Int): String = {
    val litery = linie.filter(c => c.isLetter).map(_.toLower)
    val frequencyMap = litery.groupBy(identity).view.mapValues(_.length).toMap.toSeq.sortBy(_._1)
    frequencyMap.take(maks).map { case (char, count) =>
        s"$char:${"*" * count}"
      }
      .mkString("\n")
  }

  println(histogram(5))

}

@main
def zad2: Unit = {



  def countChars(str: String): Int = {
    val uniqueChars = for {
      (char, occurrences) <- str.groupBy(
        identity
      ) 
      if occurrences.length == 1 || occurrences.length > 0
    } yield char
    uniqueChars.size
  }
    def minChars(str: String): Int = {
        str.length
  }


  val linie = io.Source.fromResource("nazwiska.txt").getLines.toList
  //print(linie)
  //val result = linie.map(line => countChars(line))
  //print(result)
  //val imie = linie.map(_.split(" ").headOption.getOrElse(""))
  val naz = linie.map(_.split(" ").lastOption.getOrElse("").length)
  
  val counts = linie.map(_.split(" ").headOption.getOrElse("")).map(part => (part, countChars(part)))
  //val counts = p.map(line => (line, countChars(line)))
  val minCount = counts.map(_._2).min

  val result = counts.filter { case (_, count) => count == minCount }.map(_._1)

  print(naz.max)

  println(result.mkString(", "))



}
  //print(minNotCon(result))

 

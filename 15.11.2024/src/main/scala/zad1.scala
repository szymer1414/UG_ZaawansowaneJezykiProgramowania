import scala.annotation.tailrec

def main(args: Array[String]): Unit = {
  CntCh
  mnc
  Swap
  Strefa
  MaterMind
  Grade
}

//zadanie 1
object CntCh {

  def countChars(str: String): Int = {

    val uniqueChars = for {
      (char, occurrences) <- str.groupBy(
        identity
      ) // Group characters by their occurrences
      if occurrences.length == 1 || occurrences.length > 0 // Yield each unique character once
    } yield char

    uniqueChars.size
  }

  println(countChars("aaabasdwbbcca"))

}
//zadanie 2
object mnc {

  def minNotCon(set: Set[Int]): Int = {

    val sortedPositives = set.filter(_ >= 0).toList.sorted
    val missing = (1 to sortedPositives.lastOption.getOrElse(1) + 1).find(n =>
      !set.contains(n)
    )

    missing.getOrElse(1)
  }
  val set1 = Set(-3, 0, 1, 2, 5, 6)
  println(minNotCon(set1))

}
//zadanie 3
object Swap {

  def swap[A](seq: Seq[A]): Seq[A] = {

    for (i <- seq.indices by 2) yield {
      if (i + 1 < seq.length)
        Seq(seq(i + 1), seq(i))
      else
        Seq(
          seq(i)
        )
    }
  }.flatten
  val set1 = Seq(1, 2, 3, 4, 5)
  println(swap(set1))

}

//zadanie 4
object Strefa {

  def stripPrefix(prefixes: Seq[String], prefixToStrip: String): Seq[String] = {
    prefixes
      .filter(_.startsWith(prefixToStrip))
      .map(_.stripPrefix(prefixToStrip))
      .sortBy(s => (s.length, s))
  }

  val strefy: Seq[String] = java.util.TimeZone.getAvailableIDs.toSeq
  println(stripPrefix(strefy, "Europe/"))

}
//zadanie 5
object MaterMind {

  def score(code: Seq[Int])(move: Seq[Int]): (Int, Int) = {

    val blacks = code.zip(move).count { case (c, m) => c == m }
    val remainingCode = code.zip(move).collect { case (c, m) if c != m => c }
    val remainingMove = code.zip(move).collect { case (c, m) if c != m => m }

    val whites = remainingMove
      .groupBy(identity)
      .map { case (color, moves) =>
        val codeCount = remainingCode.count(_ == color)
        Math.min(moves.length, codeCount)
      }
      .sum

    (blacks, whites)
  }
  val code = Seq(1, 3, 2, 2, 4, 5)
  val move = Seq(2, 1, 2, 4, 7, 2)
  val result = score(code)(move)
  println(result)
}

//zadanie 6
object Grade {
case class PersonRating(imie: String, nazwisko: String, ocenaWdzięku: Int, ocenaSprytu: Int)

val peopleRatings = Seq(
  PersonRating("Jan", "Kowalski", 8, 7),
  PersonRating("Anna", "Nowak", 9, 6),
  PersonRating("Piotr", "Wiśniewski", 7, 8)
)

// Accessing elements
println(peopleRatings(0).imie)        // Outputs: Jan
println(peopleRatings(1).ocenaSprytu) // Outputs: 6
}

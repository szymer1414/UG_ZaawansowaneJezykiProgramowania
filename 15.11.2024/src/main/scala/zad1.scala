import scala.annotation.tailrec
import scala.io.Source
def main(args: Array[String]): Unit = {
  CntCh
  mnc
  Swap
  Strefa
  MaterMind
  Grade
  Zadanie2
  Zadanie3
  Zadanie4
}

//zadanie 1
object CntCh {

  def countChars(str: String): Int = {
    str.toSet.size
  }

  println(countChars("aaabasdwbbcca"))

}
//zadanie 2
object mnc {

  def minNotCon(set: Set[Int]): Int = {
    (1 to Int.MaxValue).find(!set.contains(_)).get

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
        Seq(seq(i))
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
  case class Ocena(
      imie: String,
      nazwisko: String,
      ocenaWdzieku: Int,
      ocenaSprytu: Int
  )

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

  case class Ocena(
      imie: String,
      nazwisko: String,
      ocenaWdzieku: Int,
      ocenaSprytu: Int
  )
  val oceny = List(
    Ocena("Jan", "Kowalski", 8, 7),
    Ocena("Jan", "Kowalski", 2, 7),
    Ocena("Jan", "Kowalski", 4, 7),
    Ocena("Anna", "Nowak", 9, 6),
    Ocena("Anna", "Nowak", 9, 3),
    Ocena("Piotr", "Wiśniewski", 7, 8),
    Ocena("Adam", "Kowalski", 9, 8),
    Ocena("Jan", "Wiśniewski", 10, 7)
  )

  def obliczRanking(oceny: List[Ocena]): List[(Int, String, Double)] = {

    val grupy = oceny.groupBy(o => (o.imie, o.nazwisko))

    val wyniki = grupy.map { case ((imie, nazwisko), ocenyZawodnika) =>
      val sredniaWdzieku =
        ocenyZawodnika.map(_.ocenaWdzieku).sum.toDouble / ocenyZawodnika.size
      val sredniaSprytu =
        ocenyZawodnika.map(_.ocenaSprytu).sum.toDouble / ocenyZawodnika.size
      val suma = sredniaWdzieku + sredniaSprytu
      ((imie, nazwisko), suma, sredniaWdzieku, sredniaSprytu)
    }.toList

    val posortowane = wyniki.sortBy {
      case ((_, nazwisko), suma, sredniaWdzieku, _) =>
        (-suma, -sredniaWdzieku, nazwisko)
    }
    posortowane.zipWithIndex.map {
      case (((imie, nazwisko), suma, _, _), index) =>
        (index + 1, s"$imie $nazwisko", suma)
    }
  }

  val ranking = obliczRanking(oceny)

  println("Ranking zawodników:")
  ranking.foreach { case (miejsce, zawodnik, wynik) =>
    println(s"$miejsce. $zawodnik - Wynik: $wynik")
  }
}

object Zadanie2 {

  val statki = Source.fromResource("statki.txt").getLines().toList
  val przybycia = Source.fromResource("przybycia.txt").getLines().toList

  val shipData: Map[String, (String, Int)] = statki.map { line =>
    val Array(id, name, capacity) = line.split(";")
    id -> (name, capacity.toInt)
  }.toMap

  val pierData: Map[String, List[String]] = przybycia
    .map { line =>
      val Array(_, shipId, pierName) = line.split(";")
      pierName -> shipId
    }
    .groupBy(_._1)
    .map { case (pierName, ships) => pierName -> ships.map(_._2) }

  val result: Map[(String, Int), Set[String]] = pierData.map {
    case (pierName, shipIds) =>
      // Get ship details for each shipId
      val shipsAtPier = shipIds.flatMap(shipData.get)
      val maxCapacity = shipsAtPier.map(_._2).maxOption.getOrElse(0)
      val maxCapacityShips =
        shipsAtPier.filter(_._2 == maxCapacity).map(_._1).toSet
      (pierName, maxCapacity) -> maxCapacityShips
  }

  // Print the result
  println(result)
}

object Zadanie3 {
  case class Lokata(n: Int, słowo: String, p: Double)

  def oczyść(
      lista: List[Lokata],
      wzorzec: String,
      filtr: List[Int]
  ): List[Lokata] = {
    require(wzorzec.length == 5)
    require(
      filtr.length == 5 && filtr.forall(el => el == 0 || el == 1 || el == 2)
    )

    lista.filter { lokata =>
      val słowo = lokata.słowo
      (0 until 5).forall { i =>
        val charWzorzec = wzorzec(i)
        filtr(i) match {
          case 0 => !słowo.contains(wzorzec)
          case 1 => !(i < słowo.length && słowo(i) == charWzorzec)
          case 2 => !(i >= słowo.length || słowo(i) == charWzorzec)
        }
      }
    }
  }
// Example Usage
  val lista = List(
    Lokata(1, "abcde", 1.0),
    Lokata(2, "abxde", 2.0),
    Lokata(3, "xyzd3", 3.0),
    Lokata(4, "axxxe", 4.0),
    Lokata(5, "xxaxx", 5.0)
  )

  val wzorzec = "abcse"
  val filtr = List(0, 1, 2, 0, 2)
  val wynik = oczyść(lista, wzorzec, filtr)
  println(s"Final result: $wynik")

}

object Zadanie4 {
  def ranking(): List[(Int, Int)] = {
    val lines = Source.fromResource("test.txt").getLines().toList
    val answers =
      lines.tail.map(line => line.split(" ").tail.map(_.toInt).toList)
    val transposed = answers.transpose

    val correctAnswersCount =
      transposed.map(questionAnswers => questionAnswers.count(_ == 1))
    val numParticipants = answers.size

    // Filter out questions where less than 50% answered correctly
    val validQuestions = correctAnswersCount.zipWithIndex.filter {
      case (correctCount, _) => correctCount > numParticipants / 2
    }
    val questionRankings = validQuestions.map { case (correctCount, index) =>
      (correctCount, index + 1)
    }
    val sortedRanking = questionRankings.sortBy {
      case (correctCount, questionNumber) => (-correctCount, questionNumber)
    }

    sortedRanking.zipWithIndex.map { case ((_, questionNumber), index) =>
      (index + 1, questionNumber)
    }
  }
  val result = ranking()
  println(result.mkString(", "))
}


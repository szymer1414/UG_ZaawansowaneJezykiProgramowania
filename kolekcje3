import scala.annotation.tailrec
import scala.io.Source
def main(args: Array[String]): Unit = {
  zad1
  zad2
  zad3
  zad4
}

//zadanie 1
object zad1 {
  def Niemalejace(liczba: String): Boolean = {
    liczba.sliding(2).forall { pair => pair(0) <= pair(1) }
  }
  def Przysta(liczba: String): Boolean = {
    liczba.map(_.asDigit).sum % 2 != 0
  }
  val linie = io.Source.fromResource("liczby.txt").getLines.toList
  println(linie.filter(liczba => Niemalejace(liczba) && Przysta(liczba)))
}
//zadanie 2
object zad2 {
  def countChars(str: String): Int = {
    str.toSet.size
  }

  val linie = io.Source.fromResource("nazwiska.txt").getLines.toList
  val imionaNazwiska = linie.map { line => // split in 2
    val parts = line.split(" ")
    (
      parts.headOption.getOrElse(""),
      parts.lastOption.getOrElse("")
    )
  }
  val counts = imionaNazwiska.map { case (imie, _) =>
    (imie, countChars(imie))
  }
  val maxCount = counts.map(_._2).max
  val osobyMaxLiter = imionaNazwiska.filter { case (imie, _) =>
    countChars(imie) == maxCount
  }
  val minNazwiskoLength = osobyMaxLiter.map { case (_, nazwisko) =>
    nazwisko.length
  }.min
  val result = osobyMaxLiter.filter { case (_, nazwisko) =>
    nazwisko.length == minNazwiskoLength
  }
  println(result.map(_._2).mkString(", ")) // Drukowanie nazwisk
}

//zadanie 3
object zad3 {

  val linie = io.Source
    .fromResource("ogniem-i-mieczem.txt")
    .getLines
    .toList
    .mkString(" ")

  def histogram(maks: Int): String = {
    val litery = linie.filter(c => c.isLetter).map(_.toLower)
    val frequencyMap =
      litery.groupBy(identity).view.mapValues(_.length).toMap.toSeq.sortBy(_._1)
    frequencyMap
      .take(maks)
      .map { case (char, count) =>
        s"$char:${"*" * count}"
      }
      .mkString("\n")
  }

  println(histogram(5))

}

//zadanie 4
object zad4 {
  case class Województwo(nazwa: String, min: Int)
  // max ID gminy z województwa w: w.min + 19999
  case class Wynik(
      ID: Int,
      KOALICJA_OBYWATELSKA: Int,
      LEWICA_RAZEM: Int,
      POLEXIT: Int,
      JEDNOŚĆ_NARODU: Int,
      PIS: Int,
      EUROPA_CHRISTI: Int,
      WIOSNA: Int,
      KONFEDERACJA: Int,
      KUKIZ15: Int,
      POLSKA_FAIR_PLAY: Int
  )

  val województwa = List(
    Województwo("dolnośląskie", 20000),
    Województwo("kujawsko-pomorskie", 40000),
    Województwo("lubelskie", 60000),
    Województwo("lubuskie", 80000),
    Województwo("łódzkie", 100000),
    Województwo("małopolskie", 120000),
    Województwo("mazowieckie", 140000),
    Województwo("opolskie", 160000),
    Województwo("podkarpackie", 180000),
    Województwo("podlaskie", 200000),
    Województwo("pomorskie", 220000),
    Województwo("śląskie", 240000),
    Województwo("świętokrzyskie", 260000),
    Województwo("warmińsko-mazurskie", 280000),
    Województwo("wielkopolskie", 300000),
    Województwo("zachodniopomorskie", 320000)
  )

  val wyniki = io.Source
    .fromResource("wyniki.csv")
    .getLines
    .toList
    .map(l => {
      l.split(",").toList.map(_.toInt) match {
        case List(a, b, c, d, e, f, g, h, i, j, k) =>
          Wynik(a, b, c, d, e, f, g, h, i, j, k)
        case _ => throw new IllegalArgumentException
      }
    })

  import scala.math.abs
  val województwoMaxGlosów = województwa
    .map(woj => {
      val wynikDlaWojewództwa =
        wyniki.filter(w => w.ID >= woj.min && w.ID < woj.min + 19999)
      val sumKO = wynikDlaWojewództwa.map(_.KOALICJA_OBYWATELSKA).sum
      val sumPIS = wynikDlaWojewództwa.map(_.PIS).sum

      val amplituda = abs(sumKO - sumPIS)
      (woj.nazwa, amplituda)
    })
    .minBy(_._2)
  println(s"woj: ${województwoMaxGlosów._1}")
  println(s"Liczba : ${województwoMaxGlosów._2}")

}

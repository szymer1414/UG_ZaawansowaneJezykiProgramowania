import scala.annotation.tailrec

def main(args: Array[String]): Unit = {
  zad1
  zad2
  zad3
  zad4
  zad5
  zad6
  zad7
  zad8
  zad9
}

//zadanie 1
object zad1 {
  def subSeq[A](seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A] = {
    seq.drop(begIdx).take(endIdx - begIdx + 1)
  }
  val seq = Seq(1, 2, 3, 4, 5, 6, 7)
  println(subSeq(seq, 2, 5))
}

//zadanie 2
object zad2 {
  def remElems[A](seq: Seq[A], k: Int): Seq[A] = {
    seq.zipWithIndex.filter { case (_, index) => index != k }.map(_._1)
  }
  val seq = Seq(1, 2, 3, 4, 5, 6, 7)
  println(remElems(seq, 2)) // Output: Seq(1, 2, 4, 5)
}
//zadanie 3
object zad3 {
  def diff[A](seq1: Seq[A], seq2: Seq[A]): Seq[A] = {
    seq1.zip(seq2).collect { case (a, b) if a != b => a } ++ seq1.drop(
      seq2.length
    )
  }
  val seq1 = Seq(1, 2, 3)
  val seq2 = Seq(2, 2, 1, 3)
  println(diff(seq1, seq2)) // Output: Seq(1, 3)
}
//zadanie 4
object zad4 {
  def sumOption(seq: Seq[Option[Double]]): Double = {
    seq.foldLeft(0.0)((acc, opt) => acc + opt.getOrElse(0.0))
  }
  val seq = Seq(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6))
  println(sumOption(seq)) // Output: 7.0
}
//zadanie 5
object zad5 {
  def deStutter[A](seq: Seq[A]): Seq[A] = {
    seq.foldLeft(Seq.empty[A]) { (acc, elem) =>
      if (acc.isEmpty || acc.last != elem) acc :+ elem else acc
    }
  }
  val seq = Seq(1, 1, 2, 4, 4, 4, 1, 3)
  println(deStutter(seq)) // Output: Seq(1, 2, 4, 1, 3)
}
//zadanie 6
object zad6 {
  def isOrdered[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean = {
    seq.sliding(2).forall {
      case Seq(a, b) => leq(a, b)
      case _         => true
    }
  }
  val seq1 = Seq(1, 2, 2, 4)
  println(isOrdered(seq1)(_ < _)) // Output: false
  println(isOrdered(seq1)(_ <= _)) // Output: true
}
//zadanie 7
object zad7 {
  def freq[A](seq: Seq[A]): Set[(A, Int)] = {
    seq
      .groupBy(identity)
      .map { case (elem, occurrences) => (elem, occurrences.size) }
      .toSet
  }
  val seq = Seq('a', 'b', 'a', 'c', 'c', 'a')
  println(freq(seq)) // Output: Set(('a', 3), ('b', 1), ('c', 2))
}
//zadanie 8
object zad8 {
  def median(seq: Seq[(String, Double)]): Double = {
    val sortedScores = seq.map(_._2).sorted
    val n = sortedScores.length
    if (n % 2 == 0) (sortedScores(n / 2 - 1) + sortedScores(n / 2)) / 2
    else sortedScores(n / 2)
  }
  val seq =
    Seq(("Alice", 10.0), ("Bob", 20.0), ("Charlie", 30.0), ("David", 40.0))
  println(median(seq)) // Output: 25.0
}
//zadanie 9
object zad9 {
  def minMax(seq: Seq[(String, Double)]): Option[(String, String)] = {
    if (seq.isEmpty) None
    else Some((seq.minBy(_._2)._1, seq.maxBy(_._2)._1))
  }
  val seq =
    Seq(("Alice", 10.0), ("Bob", 20.0), ("Charlie", 30.0), ("David", 40.0))
  println(minMax(seq)) // Output: Some(("Alice", "David"))
}

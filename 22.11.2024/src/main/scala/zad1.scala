import scala.annotation.tailrec

def main(args: Array[String]): Unit = {
  Dividelist

}

//zadanie 1
object Dividelist {

  def divide[A](list: List[A]): (List[A], List[A]) = {
    @tailrec
    def helper(
        list: List[A],
        i: Int,
        list1: List[A] = List(),
        list2: List[A] = List()
    ): (List[A], List[A]) = {
      list match {
        case Nil => (list1.reverse, list2.reverse) // Base case: empty list
        case lH :: lT if (i % 2 == 0) =>
          helper(lT, i + 1, lH :: list1, list2)
        case lH :: lT if (i % 2 == 1) =>
          helper(lT, i + 1, list1, lH :: list2)
      }
    }

    helper(list, 0)
  }
  println(divide(List(1, 3, 5, 6, 7)))

}
//zadanie 2

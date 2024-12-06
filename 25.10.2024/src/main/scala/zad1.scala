import scala.annotation.tailrec

def main(args: Array[String]): Unit = {
  Dividelist
  Merging
  zad3
  zad4
  zad5
  zad6
  zad7
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
        case lH :: lT if (i % 2 == 0) =>
          helper(lT, i + 1, lH :: list1, list2)
        case lH :: lT if (i % 2 == 1) =>
          helper(lT, i + 1, list1, lH :: list2)
        case _ => (list1.reverse, list2.reverse)
      }
    }

    helper(list, 0)
  }
  println(divide(List(1, 3, 5, 6, 7)))

}
//zadanie 2
object Merging {

  def merge[A](a: List[A], b: List[A])(leq: (A, A) => Boolean): List[A] = {
    @tailrec
    def helper(a: List[A], b: List[A], acc: List[A]): List[A] =
      (a, b) match {
        case (Nil, Nil) => acc.reverse
        case (Nil, _)   => acc.reverse ::: b
        case (_, Nil)   => acc.reverse ::: a
        case (ah :: at, bh :: bt) =>
          if (leq(ah, bh)) helper(at, b, ah :: acc)
          else helper(a, bt, bh :: acc)

      }
    helper(a, b, List())
  }
  // funkcja powinna zwrócić List(1, 2, 3, 4, 5, 6, 8, 8, 10, 12).
  val a = List(1, 2, 2, 3, 5, 8, 11)
  val b = List(2, 4, 6, 8, 10, 12)
  val leq = (m: Int, n: Int) => m <= n
  println(merge(a, b)(leq))
}
//zadanie 3

object zad3 {
  def compress[A](list: List[A]): List[(A, Int)] = {
    @tailrec
    def helper(
        list: List[A],
        a: Option[A],
        count: Int,
        result: List[(A, Int)]
    ): List[(A, Int)] = list match {
      case Nil =>
        a match {
          case Some(value) => result.reverse :+ (value, count)
          case None        => result.reverse
        }
      case lH :: lT =>
        a match {
          case Some(value) if value == lH =>
            helper(lT, a, count + 1, result)
          case Some(value) =>
            helper(lT, Some(lH), 1, (value, count) :: result)
          case None =>
            helper(lT, Some(lH), 1, result)
        }

    }
    helper(list, None, 0, List.empty)
  }
  println(
    compress(List('a', 'a', 'b', 'c', 'c', 'c', 'd', 'd', 'c'))
  )
}

//zadanie 4
object zad4 {
  def isSub[A](l: List[A], lSub: List[A]): Boolean = {
    @tailrec
    def helper(l: List[A], lSub: List[A]): Boolean = lSub match {
      case Nil => true
      case lH :: lT =>
        if (l.contains(lH)) helper(l, lT)
        else false
    }
    helper(l, lSub)
  }
  val l = List('b', 'o', 'c', 'i', 'a', 'n')
  val lSub = List('a', 'b', 'c')
  println(isSub(l, lSub))
}

//zadanie 5
object zad5 {
  def compute[A, B](
      l: List[Option[A]]
  )(op1: A => B)(op2: (A, B) => B): Option[B] = {
    @tailrec
    def helper(l: List[Option[A]], acc: Option[B]): Option[B] = l match {
      case Nil => acc
      case Some(value) :: lT =>
        acc match {
          case None      => helper(lT, Some(op1(value)))
          case Some(res) => helper(lT, Some(op2(value, res)))
        }
      case None :: lT => helper(lT, acc)
    }
    helper(l, None)
  }

  // Dla: l = List(Some(1), None, Some(2), None, Some(3), Some(4)), op1 = (_ + 0), op2 = (_ + _), funkcja powinna zwrócić: Some(10).
  val l = List(Some(1), None, Some(2), None, Some(3), Some(4))
  val op1: Int => Int = _ + 0
  val op2: (Int, Int) => Int = _ + _
  println(compute(l)(op1)(op2))
}
//zadanie 6

object zad6 {

  def compose[A, B, C](f: A => B)(g: B => C): A => C = (a: A) => g(f(a))
  def prod[A, B, C, D](f: A => C, g: B => D): (A, B) => (C, D) = (a: A, b: B) =>
    (f(a), g(b))
  def lift[A](op: (Int, Int) => Int)(f: MSet[A], g: MSet[A]): MSet[A] =
    (a: A) => op(f(a), g(a))

  type MSet[A] = A => Int

// Multi-Set operations
  def sum[A](s1: MSet[A], s2: MSet[A]): MSet[A] =
    lift((x: Int, y: Int) => x + y)(s1, s2)
  def diff[A](s1: MSet[A], s2: MSet[A]): MSet[A] =
    lift((x: Int, y: Int) => Math.max(0, x - y))(s1, s2)
  def mult[A](s1: MSet[A], s2: MSet[A]): MSet[A] =
    lift((x: Int, y: Int) => Math.min(x, y))(s1, s2)

  val s1: MSet[Int] = (n: Int) =>
    n match {
      case 1 => 2
      case 3 => 1
      case _ => 0
    }

  val s2: MSet[Int] = (n: Int) =>
    n match {
      case 1 => 1
      case 3 => 2
      case _ => 0
    }

  println(sum(s1, s2)(1)) // Output: 3
  println(diff(s1, s2)(1)) // Output: 1
  println(mult(s1, s2)(3)) // Output: 1
  println(sum(s1, s2)(2)) // Output: 0
}


object zad7 {
  def group[A, B, C](l: List[A])(f: A => B)(op: A => C)(op2: (C, C) => C
  ): Set[(B, C)] = {

    @tailrec
    def helper(list: List[A], acc: List[(B, C)] = List()
    ): List[(B, C)] = {
      list match {
        case Nil => acc
        case head :: tail =>
          val key = f(head)   
          val value = op(head) 
          val updatedAcc = updateAcc(key, value, acc)(op2)
          helper(tail, updatedAcc)
      }
    }

    @tailrec
    def updateAcc( key: B, value: C, acc: List[(B, C)]
    )(op2: (C, C) => C, updated: List[(B, C)] = List()): List[(B, C)] = {
      acc match {
        case Nil => (key, value) :: updated.reverse 
        case (k, v) :: tail if k == key =>
          (k, op2(v, value)) :: (updated.reverse ++ tail) 
        case group :: tail =>
          updateAcc(key, value, tail)(op2, group :: updated) 
      }
    }

    helper(l).toSet 
  }

    val l = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val f: Int => Int = (_ % 2) 
    val op: Int => Int = (_ + 0) 
    val op2: (Int, Int) => Int = (_ + _) 

    println(group(l)(f)(op)(op2)) // Output: Set((0, 20), (1, 25))
}

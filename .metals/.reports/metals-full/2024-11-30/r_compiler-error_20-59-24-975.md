file:///C:/Users/szymer/Desktop/aa/UG_ZaawansowaneJezykiProgramowania/25.10.2024/src/main/scala/zad1.scala
### scala.MatchError: TypeDef(B,TypeBoundsTree(EmptyTree,EmptyTree,EmptyTree)) (of class dotty.tools.dotc.ast.Trees$TypeDef)

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 3882
uri: file:///C:/Users/szymer/Desktop/aa/UG_ZaawansowaneJezykiProgramowania/25.10.2024/src/main/scala/zad1.scala
text:
```scala
import scala.annotation.tailrec

def main(args: Array[String]): Unit = {
  Dividelist
  Merging
  zad3
  zad4
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
      (a.isEmpty, b.isEmpty) match {
        case (true, _) => acc.reverse ::: b
        case (_, true) => acc.reverse ::: a
        case (_, _) =>
          val ah :: at = a: @unchecked
          val bh :: bt = b: @unchecked
//            val bh :: bt = b                          ^
//    |pattern's type ::[A] is more specialized than the right hand side expression's type List[A]
//|If the narrowing is intentional, this can be communicated by adding `: @unchecked` after the expression,
          if (leq(ah, bh)) helper(at, b, ah :: acc)
          else helper(a, bt, bh :: acc)

      }
    helper(a, b, List.empty)
  }
  // funkcja powinna zwrócić List(1, 2, 3, 4, 5, 6, 8, 8, 10, 12).
  val a = List(1, 3, 5, 8)
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
        a: Option[(A, Int)],
        result: List[(A, Int)]
    ): List[(A, Int)] = list match {
      case lH :: lT =>
        a match {
          case Some((symbol, count)) if symbol == lH =>
            helper(lT, Some((symbol, count + 1)), result)
          case Some(value) =>
            helper(lT, Some((lH, 1)), result :+ value)
          case _ =>
            helper(lT, Some((lH, 1)), result)
        }
      case _ =>
        a match {
          case Some(value) => result :+ value
          case _           => result
        }
    }
    helper(list, None, List.empty)
  }
  println(
    compress(List('a', 'a', 'b', 'c', 'c', 'c', 'd', 'd', 'c'))
  ) 
}

//zadanie 4
object zad4 {
  def isSub[A](l: List[A], lSub: List[A]): Boolean = {
    @tailrec
    def helper(l: List[A], a: Set[A]): Boolean = {
      (l, a) match {
        case (_, empty) if empty.isEmpty =>
          true
        case (lH :: lT, _) =>
          val updatedSet = a - lH
          print(lT)
          helper(lT, updatedSet)
        case _ =>
          false
      }
    }
    helper(l, lSub.toSet)
  }
  val l = List('b', 'o', 'c', 'i', 'a', 'n')
  val lSub = List('a', 'b', 'c')
  println(isSub(l, lSub)) 
}


//zadanie 5
object zad5 {
  def compute[A, B](l: List[Option[A]])(op1: A => B)(op2: (A, B) => B): Option[B] = {
    @tailrec
  def helper(l: List[Option[A]], acc: Option[B]): Option[B] = l match {
    case Some(value) :: lT =>
   val updatedAcc = acc match {
        case None => Some(op1(value))
        case Some(accValue) => Some(op2(value, accValue))
      }
      helper(lT, updatedAcc)
    case None :: lT =>
      helper(lT, acc)
    
    case _ =>
      acc
}
  helper(l, None)
  }

  // Dla: l = List(Some(1), None, Some(2), None, Some(3), Some(4)), op1 = (_ + 0), op2 = (_ + _), funkcja powinna zwrócić: Some(10).
  val l = List(Some(1), None, Some(2), None, Some(3), Some(4))
  val op1 = (_ + 0), 
  val o@@
  println(isSub(l, op1))
}
```



#### Error stacktrace:

```
dotty.tools.pc.completions.KeywordsCompletions$.checkTemplateForNewParents$$anonfun$2(KeywordsCompletions.scala:218)
	scala.Option.map(Option.scala:242)
	dotty.tools.pc.completions.KeywordsCompletions$.checkTemplateForNewParents(KeywordsCompletions.scala:215)
	dotty.tools.pc.completions.KeywordsCompletions$.contribute(KeywordsCompletions.scala:44)
	dotty.tools.pc.completions.Completions.completions(Completions.scala:124)
	dotty.tools.pc.completions.CompletionProvider.completions(CompletionProvider.scala:90)
	dotty.tools.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:146)
```
#### Short summary: 

scala.MatchError: TypeDef(B,TypeBoundsTree(EmptyTree,EmptyTree,EmptyTree)) (of class dotty.tools.dotc.ast.Trees$TypeDef)
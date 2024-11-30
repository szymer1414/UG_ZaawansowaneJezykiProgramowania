file:///C:/Users/szymer/Desktop/aa/UG_ZaawansowaneJezykiProgramowania/25.10.2024/src/main/scala/zad1.scala
### scala.MatchError: TypeDef(A,TypeBoundsTree(EmptyTree,EmptyTree,EmptyTree)) (of class dotty.tools.dotc.ast.Trees$TypeDef)

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 837
uri: file:///C:/Users/szymer/Desktop/aa/UG_ZaawansowaneJezykiProgramowania/25.10.2024/src/main/scala/zad1.scala
text:
```scala
import scala.annotation.tailrec

def main(args: Array[String]): Unit = {
  Dividelist
  Merging
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

  def merge[A](a: List[A], b: List[A])(leq: (A, A) => Boolean): List[A] 
    @tailrec
    d@@
    def helper(
        a: List[A],
        b: List[A],
        acc: List[A]): List[A] = (a, b) match = {
        
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
  //funkcja powinna zwrócić List(1, 2, 3, 4, 5, 6, 8, 8, 10, 12).
  val a = List(1 ,3, 5, 8)
  val b = List(2, 4, 6, 8, 10, 12)
  println(merge(a, b)((m, n)=> m < n))

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

scala.MatchError: TypeDef(A,TypeBoundsTree(EmptyTree,EmptyTree,EmptyTree)) (of class dotty.tools.dotc.ast.Trees$TypeDef)
file:///C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/25.10.2024/src/main/scala/zad1.scala
### java.lang.AssertionError: NoDenotation.owner

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.3\scala3-library_3-3.3.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 324
uri: file:///C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/25.10.2024/src/main/scala/zad1.scala
text:
```scala
import scala.annotation.tailrec

def main(args: Array[String]): Unit = {
  Dividelist

}

//zadanie 1
object Dividelist {

  def divide[A](list: List[A]): (List[A], List[A]) ={ /* ... */
    @tailrec
    def helper[A](list: List[A]): (List1[A], List2[A])= {
      list match {
    case A%2==0 => {List1::Lista[@@]



    }
    helper(list[A+1])
  }
  println(divide(List(1, 3, 5, 6, 7)))

}
//zadanie 2
object PrimeNr {
  def isPrime(num: Int): Boolean = {
    @tailrec
    def helper(num: Int, acc: Int = 2): Boolean = {
      if (num <= 1) {
        false
      } else if (acc > math.sqrt(num)) {
        true
      } else if (num % acc == 0) {
        false
      } else {
        helper(num, acc + 1)
      }
    }
    helper(num)
  }
  println(isPrime(19))
//zadanie 3
}

```



#### Error stacktrace:

```
dotty.tools.dotc.core.SymDenotations$NoDenotation$.owner(SymDenotations.scala:2607)
	scala.meta.internal.pc.SignatureHelpProvider$.isValid(SignatureHelpProvider.scala:83)
	scala.meta.internal.pc.SignatureHelpProvider$.notCurrentApply(SignatureHelpProvider.scala:96)
	scala.meta.internal.pc.SignatureHelpProvider$.$anonfun$1(SignatureHelpProvider.scala:48)
	scala.collection.StrictOptimizedLinearSeqOps.dropWhile(LinearSeq.scala:280)
	scala.collection.StrictOptimizedLinearSeqOps.dropWhile$(LinearSeq.scala:278)
	scala.collection.immutable.List.dropWhile(List.scala:79)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:48)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:435)
```
#### Short summary: 

java.lang.AssertionError: NoDenotation.owner
file:///C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/11.10.2024/src/main/scala/zad1.scala
### java.lang.AssertionError: NoDenotation.owner

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.3\scala3-library_3-3.3.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 482
uri: file:///C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/11.10.2024/src/main/scala/zad1.scala
text:
```scala

//BEZ petli oraz zmiennych [var??]

//rekurencyjna funckaj reverse(str: String): String, ktora zwroci odwrocony napis jako argument

object ReverseString {
def reverse(str: String): String ={
  if(str.isEmpty) ""
  else reverse(str.tail)+str.head
}

val napis = "losowy napis czesc"
val res = reverse(napis)
println(res)



object palindormcheck {
def palindome(tab: Array[int]): Boolean ={
  if(str.isEmpty) ""
  else reverse(str.tail)+str.head
}

val tab [@@]
val res = reverse(napis)
println(res)
}


def main(args: Array[String]): Unit = {
  }
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
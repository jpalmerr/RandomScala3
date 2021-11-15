val g: Int ?=> String = s"Got: ${summon[Int]}"

val gg: ContextFunction1[Int, String] = g

/*
Context functions are regular values
that can be passed around as parameters or stored in collections.

We can invoke a context function by explicitly providing the implicit parameters
*/

g(using 16)

val g1: Int ?=> Boolean ?=> String = s"${summon[Int]} ${summon[Boolean]}"
val g2: (Int, Boolean) ?=> String = s"${summon[Int]} ${summon[Boolean]}"

def run1(f: Int ?=> Boolean ?=> String): Unit =
  println(f(using 9)(using false))
def run2(f: Boolean ?=> Int ?=> String): Unit =
  println(f(using true)(using 10))
def run3(f: (Boolean, Int) ?=> String): Unit =
  println(f(using false, 11))

run1(g1)
run2(g1)
run3(g1)

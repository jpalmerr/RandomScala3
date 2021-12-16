import scala.util.CommandLineParser as CLP

object HelloWorld {
  @main def m(args: String*) =
  // Say hello to the first argument
    if (args.isEmpty) println("Hello") else println("Hello, " + args(0) + "!")
}
// sbt "run James Palmer"
// sbt "run"
package extensionPatterns

// avoid creating a syntax trait with extension

import io.circe.Json

trait Encoder[T] {
  extension (t: T) {
    def encode(): Json
  }
}

case class MyClass()

object Main {
  given Encoder[MyClass] with {
    //...and the implementation here
    extension (myClass: MyClass) {
      def encode(): Json = ???
    }
  }

  //we can switch to context bounds now,
  //and use the extension method directly
  def encodeToJson[T: Encoder](t: T): Json = t.encode()
}

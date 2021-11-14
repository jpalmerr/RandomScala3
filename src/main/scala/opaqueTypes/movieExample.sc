object types {
  opaque type Year = Int

  object Year {
    def apply(value: Int): Year = value
  }

  val year: Year = Year(2000)

  extension (year: Year) {
    def value: Int = year
  }



}
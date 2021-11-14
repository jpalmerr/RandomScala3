/*
Opaque type alias is a feature that helps to implement domain-specific models in a better way

i.e think of cases where the use of AnyVal was necessary
 */

final case class MovieExampleOne(name: String, year: Int, runningTime: Int, noOfOscarsWon: Int)

/*
Here, we have three fields of type Int.
There’s a chance that, while populating the entity, we might accidentally fill the year field with the runningTime value
Will still compile
Type Alias won't solve our problem
*/

case class Year(year:Int)
case class RunningTimeInMin(runningTime:Int)
case class NoOfOscarsWon(noOfOscarsWon:Int)

final case class Movie(name: String, year: Year, runningTime: RunningTimeInMin, noOfOscarsWon: NoOfOscarsWon)

// Great, however this comes with performance overhead

// This is where opaque types can be useful


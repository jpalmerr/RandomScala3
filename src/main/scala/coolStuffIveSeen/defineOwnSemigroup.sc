/**
 * when you want cats semigroup on your own type
 */

import cats.{Monad, Semigroup}
import cats.data.EitherT
import cats.implicits.*
import cats.syntax.semigroup.*

trait Platform

object MyPlatforms:
  case object PlatformOne extends Platform
  case object PlatformTwo extends Platform

  val all: List[Platform] = List(PlatformOne, PlatformTwo)
end MyPlatforms

trait MyOperations[F[_]]:
  def operationOne(someParam: String): F[Either[String, Unit]]
  def operationTwo(someParam: Int): F[Either[String, Unit]]

object MyOperations:
  given [F[_]: Monad]: Semigroup[MyOperations[F]] with
    override def combine(x: MyOperations[F], y: MyOperations[F]): MyOperations[F] =
      new MyOperations[F] {
        override def operationOne(someParam: String) =
          EitherT(x.operationOne(someParam)).productR(EitherT(y.operationOne(someParam))).value

        override def operationTwo(someParam: Int) =
          EitherT(x.operationTwo(someParam)).productR(EitherT(y.operationTwo(someParam))).value
    }
end MyOperations


case class MyCombiner[F[_]: Monad](
  platformOne: MyOperations[F],
  platformTwo: MyOperations[F]
):
  def forPlatform(platform: Platform): MyOperations[F] =
    platform match {
      case MyPlatforms.PlatformOne => platformOne
      case MyPlatforms.PlatformTwo => platformTwo
    }

  def forBothPlatforms: MyOperations[F] =
    MyPlatforms.all.map(forPlatform).reduce(_ |+| _) // we wouldn't have access to cats semigroup methods like here without our defined semigroup



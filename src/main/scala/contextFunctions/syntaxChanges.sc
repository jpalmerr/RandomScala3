import scala.concurrent.{ExecutionContext, Future}
// scala 2

case class UserA(email: String)
def newUser(u: UserA)(
  implicit ec: ExecutionContext): Future[Boolean] = {
  lookupUserA(u.email).flatMap {
    case Some(_) => Future.successful(false)
    case None => saveUserA(u).map(_ => true)
  }
}
def lookupUserA(email: String)(
  implicit ec: ExecutionContext): Future[Option[UserA]] = ???
def saveUserA(u: UserA)(
  implicit ec: ExecutionContext): Future[Unit] = ???

// scala 3

type Executable[T] = ExecutionContext ?=> Future[T]

// Any method where the result type is an Executable[T],
// will require a given (implicit) execution context to obtain the result (the Future)

case class User(email: String)
def newUser(u: User): Executable[Boolean] = {
  lookupUser(u.email).flatMap {
    case Some(_) => Future.successful(false)
    case None => saveUser(u).map(_ => true)
  }
}
def lookupUser(email: String): Executable[Option[User]] = ???
def saveUser(u: User): Executable[Unit] = ???
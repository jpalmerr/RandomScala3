```scala worksheet
def newUser(u: User)(implicit ec: ExecutionContext): Future[Boolean]
```

^ is a running computation, which will eventually return a boolean

```scala worksheet
type Executable[T] = ExecutionContext ?=> Future[T]


def newUser(u: User): Executable[Boolean]
```

^ returns a lazy computation, which will only be run when an ExecutionContext is provided

This makes it easier to govern when and how the computations are run
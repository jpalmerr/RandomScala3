# Open class

https://docs.scala-lang.org/scala3/reference/other-new-features/open-classes.html

## What?

It signals that the class is planned for extension

Using it allows for us to write extending class
- in a different source file
- without using `import scala.language.adhocExtensions`

## Why?

One of three expectations when extending a class 

1. Class is intended to allow extensions => use `open`
2. Extensions are forbidden => use `final`
3. No firm decision either way => no modifier

## Real life example

I saw it used as `open class PostgresStore`

- `trait Store` defined all the methods all stores require
    - lift
    - commit

- `open class PostgresStore` implemented those methods

- `trait CatalogueStore`, `trait ImageStore` etc defined the methods stores specific to db tables needs

- final implementation then looked something like

```scala
class PostgresImageStore[F] extends PostgresStore[F] with ImageStore[F]  
```


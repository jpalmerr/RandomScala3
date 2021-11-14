ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "RandomScala3"
  )

val circeVersion = "0.14.1"
val http4sVersion = "0.23.1"

val circe = Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

val http4s = Seq(
  "org.http4s"            %% "http4s-blaze-client",
  "org.http4s"            %% "http4s-blaze-server",
  "org.http4s"            %% "http4s-circe",
  "org.http4s"            %% "http4s-dsl"
).map( _ % http4sVersion)


libraryDependencies ++= circe ++ http4s
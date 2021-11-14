import sbt._

object Dependency {

  val Http4s          = "0.23.26"
  val Circe           = "0.14.1"

  val deps: Seq[ModuleID] = Seq(
    "io.circe"                   %% "circe-core"             % Circe,
    "org.http4s"                 %% "http4s-blaze-client"    % Http4s,
    "org.http4s"                 %% "http4s-blaze-server"    % Http4s,
    "org.http4s"                 %% "http4s-circe"           % Http4s,
  )

  def apply(): Seq[ModuleID] = deps
}

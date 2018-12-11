import scala.collection.Seq

homepage in ThisBuild := Some(url("https://github.com/slamdata/$name;format="lower,hyphen"$"))

scmInfo in ThisBuild := Some(ScmInfo(
  url("https://github.com/slamdata/$name;format="lower,hyphen"$"),
  "scm:git@github.com:slamdata/$name;format="lower,hyphen"$.git"))

// Include to also publish a project's tests
lazy val publishTestsSettings = Seq(
  publishArtifact in (Test, packageBin) := true)

lazy val root = project
  .in(file("."))
  .settings(noPublishSettings)
  .aggregate(core)
  .enablePlugins(AutomateHeaderPlugin)

lazy val core = project
  .in(file("core"))
  .settings(name := "$name;format="lower,hyphen"$")
  .settings(
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.2.4"))
  .settings(
    performMavenCentralSync := false,
    publishAsOSSProject := $open_source$)
  .enablePlugins(AutomateHeaderPlugin)

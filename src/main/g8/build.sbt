ThisBuild / crossScalaVersions := Seq("2.12.10")
ThisBuild / scalaVersion := (ThisBuild / crossScalaVersions).value.head

ThisBuild / githubRepository := "$name;format="lower,hyphen"$"

ThisBuild / homepage := Some(url("https://github.com/precog/$name;format="lower,hyphen"$"))

ThisBuild / scmInfo := Some(ScmInfo(
  url("https://github.com/precog/$name;format="lower,hyphen"$"),
  "scm:git@github.com:precog/$name;format="lower,hyphen"$.git"))

ThisBuild / publishAsOSSProject := $open_source$

// Include to also publish a project's tests
lazy val publishTestsSettings = Seq(
  Test / packageBin / publishArtifact := true)

lazy val root = project
  .in(file("."))
  .settings(noPublishSettings)
  .aggregate(core)

lazy val core = project
  .in(file("core"))
  .settings(name := "$name;format="lower,hyphen"$")

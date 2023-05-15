import Dependencies.*

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := Versions.scala3
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings)
  .settings(
    IntegrationTest / fork := true,
    libraryDependencies ++=
      cats ++
        kinesis4cats ++
        scalatest ++
        testcontainers ++
        awsSdkV1 ++
        awsSdkV2
  )

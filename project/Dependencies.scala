import sbt.*

object Dependencies {
  lazy val cats = Seq("org.typelevel" %% "cats-effect" % Versions.cats)
  lazy val kinesis4cats = Seq(
    "io.github.etspaceman" %% "kinesis4cats-kcl" % Versions.kinesis4cats
  )
  lazy val scalatest = Seq("org.scalatest" %% "scalatest" % Versions.scalatest)
  lazy val testcontainers = Seq(
    "com.dimafeng" %% "testcontainers-scala-scalatest" % Versions.testcontainers % "it,test",
    "com.dimafeng" %% "testcontainers-scala-localstack-v2" % Versions.testcontainers % "it,test"
  )
  lazy val awsSdkV1 = Seq(
    "com.amazonaws" % "aws-java-sdk-s3" % Versions.awsSdkV1,
    "com.amazonaws" % "aws-java-sdk-sqs" % Versions.awsSdkV1
  )
  lazy val awsSdkV2 = Seq(
    "software.amazon.awssdk" % "bom" % Versions.awsSdkV2,
    "software.amazon.awssdk" % "s3" % Versions.awsSdkV2,
    "software.amazon.awssdk" % "sqs" % Versions.awsSdkV2
  )
}

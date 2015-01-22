name := "scalalda"

version := "0.1"

scalaVersion := "2.11.4"

organization := "me.shuaishuai"

resolvers ++= Seq(
  "ScalaNLP Maven2" at "http://repo.scalanlp.org/repo",
  "Scala Tools Snapshots" at "http://scala-tools.org/repo-snapshots/"
)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-swing" % "2.9.1",
  "org.scalala" %% "scalala" % "1.0.0.RC2",
  "org.scalanlp" %% "scalanlp-data" % "0.4.RC1"
)

libraryDependencies <<= (scalaVersion, libraryDependencies) { (sv, deps) =>
  sv match {
    case "2.9.1" =>
      (deps :+ ("org.scalatest" % "scalatest" % "1.4.RC2" % "test")
        :+ ("org.scala-tools.testing" %% "scalacheck" % "1.9" % "test"))
    case x if x.startsWith("2.8") =>
      (deps :+ ("org.scalatest" % "scalatest" % "1.3" % "test")
        :+ ("org.scala-tools.testing" % "scalacheck_2.8.1" % "1.8" % "test"))
    case x  => error("Unsupported Scala version " + x)
  }
}

javacOptions ++= Seq("-source", "1.5", "-target", "1.5")

scalacOptions ++= Seq("-no-specialization","-deprecation","-target:jvm-1.5")

name := "fuzzy"

version := "1.0"

inThisBuild(Seq(
  scalaOrganization := "org.typelevel",
  scalaVersion := "2.12.2-bin-typelevel-4"
))

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.0.0-RC1",
  "com.chuusai" %% "shapeless" % "2.3.2"
)

scalacOptions ++= Seq(
  "-explaintypes",                     // Explain type errors in more detail.
  "-language:higherKinds",             // Allow higher-kinded types
  "-language:implicitConversions",     // Allow definition of implicit functions called views
  "-Yinduction-heuristics",       // speeds up the compilation of inductive implicit resolution
  "-Ykind-polymorphism",          // type and method definitions with type parameters of arbitrary kinds
  "-Yliteral-types",              // literals can appear in type position
  "-Xstrict-patmat-analysis",     // more accurate reporting of failures of match exhaustivity
  "-Xlint:strict-unsealed-patmat" // warn on inexhaustive matches against unsealed traits
)

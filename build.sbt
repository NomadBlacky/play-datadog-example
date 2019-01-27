lazy val root = (project in file("."))
  .enablePlugins(PlayScala, JavaAppPackaging, JavaAgentPackaging)
  .settings(
    name := "play-datadog-example",
    organization := "com.github.nomadblacky",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.12.8",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
    ),
    javaAgents += "com.datadoghq" % "dd-java-agent" % "0.22.0",
    mappings in Universal ++= Seq(
      file("Procfile") -> "Procfile"
    )
  )

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.github.nomadblacky.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.github.nomadblacky.binders._"

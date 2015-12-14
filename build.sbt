mainClass := Some("editorLauncher.editor.launcher.Launcher")

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

//lazy val root = (project in file(".")).
//  settings(
//    version := "0.1.0",
//    scalaVersion := "2.11.4",
//    mainClass := Some("editorLauncher.editor.launcher.Launcher")
//  ) aggregate(standardResource, standardModel, standardView,
//  standardController, standardLauncher, editorModel, editorController, editorView, editorLauncher)

lazy val standardResource = (project in file("standardResource")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  )

lazy val standardModel = (project in file("standardModel")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn (standardResource)

lazy val standardController = (project in file("standardController")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn (standardModel)

lazy val standardView = (project in file("standardView")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel, standardController)

lazy val standardLauncher = (project in file("standardLauncher")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel, standardController, standardView)

mainClass := Some("editorLauncher.editor.launcher.Launcher")

lazy val root = (project in file(".")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4",
    mainClass := Some("editorLauncher.editor.launcher.Launcher")
  ) aggregate(standardResource, standardModel, standardView,
  standardController, standardLauncher, editorModel, editorController, editorView, editorLauncher)

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

lazy val editorModel = (project in file("editorModel")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel)

lazy val editorController = (project in file("editorController")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel, standardController, editorModel)

lazy val editorView = (project in file("editorView")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel, standardController, standardView, editorModel, editorController)

lazy val editorLauncher = (project in file("editorLauncher")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel, standardController, standardView, editorModel, editorController, editorView)

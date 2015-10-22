package standard.resources

import scala.io.Source

object Fonction {
  def getPathImgMap(lien : String) = {
    Source.fromFile(lien)
  	      .getLines()
  	      .find(_.startsWith("img="))
  	      .get
  	      .replace("img=", "")
  }
  
}
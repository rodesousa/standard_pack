package standard.view.swing.model

import standard.model.Model

/**
 * Created by rodesousa on 20/10/15.
 */

class ViewModel(_model : Model) {
  val dialogue = new Dialogue
  val model = _model
}
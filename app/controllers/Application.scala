package controllers

import play.api.mvc._

class Application extends Controller {
  val index = Action {
    Ok("Play blank app")
  }
}

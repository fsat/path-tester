package controllers

import play.api.mvc._

class Application extends Controller {
  val baz = Action { implicit request =>
    val method = request.method
    val queryString = request.rawQueryString
    Ok(s"baz  - request path [${request.path}] - method [$method] - query string [$queryString]")
  }

  def boomBox(input: String) = Action { implicit request =>
    val method = request.method
    val queryString = request.rawQueryString
    Ok(s"boomBox - input [$input] - request path [${request.path}] - method [$method] - query string [$queryString]")
  }
}

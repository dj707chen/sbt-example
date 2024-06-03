import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object Macros {
  def impl(c: blackbox.Context)(): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](q"""println("Hello World")""")
  }

  def hello(): Unit = macro impl
}

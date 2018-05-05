package expression
import context._
import value._

case class Declaration(id: Identifier, exp: Expression) extends SpecialForm
{
  def execute(env: Environment): Value = 
  {
    val exec = exp.execute(env)
    env.put(id, exec)
    Notification.OK
  }
}
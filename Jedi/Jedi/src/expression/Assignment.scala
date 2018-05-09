package expression
import value._
import context._

case class Assignment(val vbl: Identifier, val update: Expression) extends SpecialForm{
  def execute(env: Environment) = 
  {
    /*
     * The left hand side is the identifier. The right hand side is the expression. 
     * Execute the identifier which returns a variable, and if it’s not one, throw an exception. 
     * Execute the expression. And then place the value into the content of the variable name. 
     * 
     */
    val variable = vbl.execute(env)
    if(!variable.isInstanceOf[Variable]) throw new JediException("must be a variable")
    else 
    {
      val res = update.execute(env)
      variable.asInstanceOf[Variable].content = res
    }
    Notification.DONE
  }
}
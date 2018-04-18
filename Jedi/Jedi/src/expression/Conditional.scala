package expression
import context._
import value._

case class Conditional(val cond: Expression, val cons: Expression, val alt: Expression = null) extends SpecialForm
{
  
  /**
   *   Similarly conditionals (if/else) use a form of lazy execution called conditional execution—execute the condition. 
   *   If it's true, execute the consequent and ignore the alternative. 
   *   If it's false, execute the alternative (if it's not null, if it is, return Notification.UNSPECIFIED) and ignore the consequent.
   */
   def execute(env: Environment): Value = 
   {
     val exec = cond.execute(env)
     exec match 
          {
            case b: Boole => if (b.value) cons.execute(env) 
                             else {if(alt != null) alt.execute(env) else Notification.UNSPECIFIED}
            case _ => Notification.UNSPECIFIED
          } 
   }
}
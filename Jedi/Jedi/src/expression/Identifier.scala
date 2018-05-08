package expression
import value._

/**
 * Identifiers are names of values. To execute an identifier we simply look it up in the environment.
 */
case class Identifier(val name: String) extends Expression {
   override def toString = name
   
   
   def execute(env: context.Environment) = 
   {
     val exec = env(this)
     exec match 
     {
       case th: Thunk => th.apply(List(exec))
       case t: Text => t.body.execute(env); 
       case _ => exec
     }
   }
}

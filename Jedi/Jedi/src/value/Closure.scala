package value
import expression._
import context._

class Closure(val parameters: List[Identifier], val body: Expression, val defEnv: Environment, val callEnv: Environment = new Environment) extends Value
{
   def apply (args: List[Value]) = {
     if(Flags.useStaticScopeRule)
     {
       val tempEnv = new Environment(defEnv)
       tempEnv.bulkPut(parameters, args)
       body.execute(tempEnv)
     }
     
     else
     {
        val tempEnv = new Environment(callEnv)
        tempEnv.bulkPut(parameters, args)
        body.execute(tempEnv)
     }
  } 
}

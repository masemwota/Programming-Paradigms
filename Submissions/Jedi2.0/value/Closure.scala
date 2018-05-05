package value
import expression._
import context._

class Closure(val parameters: List[Identifier], val body: Expression, val defEnv: Environment) extends Value
{
   def apply (args: List[Value]) = {
    /*
     * tempEnv = new Env(defEnv)
			tempEnv.bulkput(params, args) 
			Execute body in tempEnv 
     */
    val tempEnv = new Environment(defEnv)
    tempEnv.bulkPut(parameters, args)
    body.execute(tempEnv)
  } 
}

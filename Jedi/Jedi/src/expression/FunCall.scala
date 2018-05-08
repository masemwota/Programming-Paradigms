package expression
import value._
import context._

/**
 * FunCalls (i.e., function calls or applications) use eager execution by default-- all operands (i.e., inputs) are executed, even if they don't need to. 
 * However, flags allow users to change this to pass-by-name or pass-by-text, two forms of lazy execution in which only needed operands are executed.
 */
case class FunCall(val operator: Identifier, val ops: List[Expression]) extends Expression {
 
  def execute(env: context.Environment): value.Value = 
  {
      var myEnv = env  
      if(!Flags.useStaticScopeRule) myEnv = new Environment()
      
      var arguments: List[Value] = List()
      val p = Flags.paramaterPassing
     
      p match 
      {
        case Flags.passByName => arguments = ops.map((n: Expression) => new Thunk(n, myEnv))
        case Flags.passByText => arguments = ops.map((n: Expression) => new Text(n))
        case Flags.passByValue => arguments = ops.map(_.execute(myEnv))
        //case _ => arguments
      }
    
      if(myEnv.contains(operator))
      {
        val maybeClosure = operator.execute(myEnv) //operator is name of a function 
        if (maybeClosure.isInstanceOf[Closure]) 
        {
           val closure = maybeClosure.asInstanceOf[Closure]
           closure.apply(arguments)
        }
        
        else 
        {
          throw new TypeException("Only functions can be called")
        }
      }
    
      else 
      {
        val args = ops.map(_.execute(myEnv))
        alu.execute(operator, args)
      }
  }
}
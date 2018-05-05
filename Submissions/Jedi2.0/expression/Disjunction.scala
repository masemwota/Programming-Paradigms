package expression
import context._
import value._
                                                  
case class Disjunction(operands: List[Expression]) extends SpecialForm
{
    def execute(env: context.Environment) = 
    {
      def helper(ops: List[Expression], result: Boole): value.Boole = 
      {
        if(!result.value)
        {
          val exec = ops.head.execute(env)
          exec match 
          {
            case b: Boole => helper(ops.tail, Boole(b.value || result.value)) 
            case _ => throw new TypeException("Disjunction takes a Boole")
          }
        }
          
        else Boole(true)
        }
        
        helper(operands, Boole(false))
    }
}

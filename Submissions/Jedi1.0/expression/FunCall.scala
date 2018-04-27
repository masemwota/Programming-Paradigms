package expression

/**
 * FunCalls (i.e., function calls or applications) use eager execution by default-- all operands (i.e., inputs) are executed, even if they don't need to. 
 * However, flags allow users to change this to pass-by-name or pass-by-text, two forms of lazy execution in which only needed operands are executed.
 */
case class FunCall(val operator: Identifier, val ops: List[Expression]) extends Expression {

  def execute(env: context.Environment): value.Value = 
  {
    val arguments = ops.map((op: Expression) => op.execute(env))
    context.alu.execute(operator, arguments)
    }
}
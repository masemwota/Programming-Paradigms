package expression

trait Literal extends value.Value with Expression{
  def execute(env: context.Environment) = this
}
package value

case class Boole (val value: Boolean) extends expression.Literal
{
    def && (other: Boole) = Boole(this.value && other.value)
    def || (other: Boole) = Boole(this.value || other.value)
    
    def unary_! = Boole(!this.value) 
}
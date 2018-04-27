package value

case class Chars(val value: String) extends expression.Literal with Equals
{
  //def < (other: Chars) = Chars(Boole(this.value.compareTo(other.value) < 0).toString)
  //def == (other: Chars) = Chars(Boole(this.value.equals(other.value)).toString)
  
  def < (other: Chars) = this.value.compareTo(other.value) < 0
  def == (other: Chars) = this.value.equals(other.value)
  
  def substring (begin: Integer, end: Integer) = value.substring(begin.value, end.value)
  
  def + (other: Chars) = Chars(this.value + other.value)
  override def toString = this.value
}

object Chars {
  //implicit def StringtoChars (n: String): Chars = Chars(n)
}
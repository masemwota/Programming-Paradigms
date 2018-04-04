package value

case class Integer(val value: Int) extends expression.Literal with Ordered[Integer] with Equals {
    //+,*, -, /
  def +(other: Integer) = Integer(this.value + other.value)
  def *(other: Integer) = Integer(this.value * other.value)
  def -(other: Integer) = Integer(this.value - other.value)
  def /(other: Integer) = if (other.value == 0) throw new Exception else Integer(this.value / other.value)
  
  //def <(other: Integer) = this.compare(other) < 0

  def unary_- = Integer(-this.value) // unary negation
  override def toString = value.toString
  def compare(other: Integer): Int = if (this.value < other.value) -1 else if (other.value < this.value) 1 else 0
  override def canEqual(other: Any) =  other.isInstanceOf[Integer]
  override def equals(other: Any): Boolean = 
    other match {
       case other: Integer => this.canEqual(other) && (other.value == this.value)
       case _ => false
    }
  override def hashCode = this.toString.##
}

object Integer {
  //implicit def intToReal(n: Integer): Real = Real(n.value.toDouble)
}


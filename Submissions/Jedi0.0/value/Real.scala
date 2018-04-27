package value

case class Real(val value: Double) extends expression.Literal with Ordered[Double] with Equals {
    //+,*, -, /
  def +(other: Real) = Real(this.value + other.value)
  def *(other: Real) = Real(this.value * other.value)
  def -(other: Real) = Real(this.value - other.value)
  def /(other: Real) = if (other.value == 0) throw new Exception else Real(this.value / other.value)
  
  def <(other: Real) = if(this.compare(other) < 0) true else false

  def unary_- = Real(-this.value) // unary negation
  override def toString = value.toString
  def compare(other: Real): Int = if (this.value < other.value) -1 else if (other.value < this.value) 1 else 0
  def compare(other: Double): Int = if (this.value < other) -1 else if (other < this.value) 1 else 0
  override def canEqual(other: Any) =  other.isInstanceOf[Real]
  override def equals(other: Any): Boolean = 
    other match {
       case other: Real => this.canEqual(other) && (other.value == this.value)
       case _ => false
    }
  override def hashCode = this.toString.##
}



/* Problem 2 -- Generics*/

object genericsTest extends App {

  import scala.collection.mutable.ArrayBuffer

  class Queue[T] () 
  {
    private val elements: ArrayBuffer[T] = new ArrayBuffer[T]()
  
    def enqueue(element: T) {elements += element}
    
    def dequeue() = 
    { 
      elements.head
      elements.remove(0)
    }
    
    def isEmpty = elements.isEmpty
    
    override
    def toString =
    {
      var theArray = ""
      for(a <- elements) 
      {
        theArray += a + "\n"
      }
      theArray
    }
  }


  object Queue
  {
    def apply = new Queue()
  }
      //In main create a queue of names called waitingList. 
      val waitingList = new Queue[String]
      
      //Add five names, print the queue, then iteratively remove and print items from the queue until it is empty.
      waitingList.enqueue("Marietta")
      waitingList.enqueue("Monsi")
      waitingList.enqueue("Stan")
      waitingList.enqueue("Parth")
      waitingList.enqueue("Priscilla")
      
      print(waitingList.toString)
      
      while(!waitingList.isEmpty) 
      {
        print(waitingList.dequeue() + " ")
      }
  
      /*
       Result: 
         Marietta
				Monsi
				Stan
				Parth
				Priscilla
				Marietta Monsi Stan Parth Priscilla 
       */
}
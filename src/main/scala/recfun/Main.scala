package recfun

object Main  {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c<=0 || c==r) { 1 }
      
      else { pascal(c-1, r-1)+pascal(c, r-1)}
      
      
    }
     
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      //chars.isEmpty: Boolean returns whether a list is empty
//chars.head: Char returns the first element of the list
//chars.tail: List[Char] returns the list without the first element
     def leftCounter(chars: List[Char], count : Int): Boolean = {
       if (count<0 || (chars.isEmpty && count > 0)) { return false}
      
       else if (chars.isEmpty && count == 0) { return true;}
       else if (chars.head == '('){return leftCounter(chars.tail, count+1) }
       
       else if (chars.head == ')'){return leftCounter(chars.tail, count-1) }
       else {return leftCounter(chars.tail, count)}
     }
     return leftCounter(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) { return 1 }
      else if (coins.isEmpty || money <0) { return 0}
      
      else {
        return countChange(money - coins.head, coins) + countChange(money, coins.tail)
      }
    }
  }

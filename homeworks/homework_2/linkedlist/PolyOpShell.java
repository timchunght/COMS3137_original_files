/*
Program represents polynomials in a linked list.

For all the methods, feel free to change the type of object to the name of your own linked list
and to change the return type. The current names are just there as a skeleton. 
However, remember to make sure that you MUST implement a linked list yourself.
 */

public class PolyOpShell {

	// Input (part a) in the main 
	public static void main(String[] args) {
	}
	
	
	// inserts each object based on decreasing exponent value
	void insertInOrder() {
	}
	
	
 	// add polynomials
	void addPoly(LinkedList L1, LinkedList L2, LinkedList L3) {
	}
	
	
	// subtract polynomials
	void subtractPoly(LinkedList L1, LinkedList L2, LinkedList L3) {
	}
	
	
	// multiply polynomials, using actual multiply operation (not iterative addition)
	void multPoly(LinkedList L1, LinkedList L2, LinkedList L3) {
	}
	
	
	// evaluates the polynomial
	void evalPoly(LinkedList L1, int value) {
	}
	
	
	// prints out the polynomial
	void printpoly(LinkedList L1) {
	}
}


/*
  This class is the default code from the pdf file 
  that represents a possible Java class for a polynomial term.
*/

class PolyTerm {
	  private double coef;
	  private int exponent;
	PolyTerm() {
	coef=0.0;
	      exponent=0;
	    }
	    PolyTerm(double c, int e)
	    {
	coef=c;
	      exponent=e;
	    }
	    public void setPolyTerm(double c, int e)
	    {
	coef=c;
	      exponent=e;
	    }
	    public int getExponent()
	    {    return exponent;  }
	    public double getCoef()
	    {    return coef;   }
	      public String toString()
	    {  return coef + " x^" + exponent; }
}

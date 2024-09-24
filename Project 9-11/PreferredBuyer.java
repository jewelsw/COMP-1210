   /** 
 *practice with inheritance and using different classes.
 *
 *Project 8 -- part b
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/06/2023
 */
public class PreferredBuyer extends Buyer {
//no fields added
//constructor
/**
*inherits Buyer's strings and sets category field.
*
*@param acctNumber string
*@param name string
*/
   public PreferredBuyer(String acctNumber, String name) {
      super(acctNumber, name);
      category = "Preferred Buyer";
   }
//methods
/**
*overrides calcAwardPoints from Buyer and gets int value for 
*subtotal.
*
*@return awardPoints int
*/
   public int calcAwardPoints() {
      double subtotal = calcSubtotal();
      int awardPoints = (int) subtotal;
      return awardPoints;
   }
}
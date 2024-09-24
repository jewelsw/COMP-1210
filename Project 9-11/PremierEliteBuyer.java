import java.text.DecimalFormat;
 /** 
 *practice with inheritance and using different classes.
 *
 *Project 8 -- part d
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/06/2023
 */
public class PremierEliteBuyer extends EliteBuyer {
//instance variables
   private int bonusAwardPoints = 1000;
//constructor
/**
*inherits all of Buyer and EliteBuyer variables.
*
*@param acctNumber string
*@param name String
*/
   public PremierEliteBuyer(String acctNumber, String name) {
      super(acctNumber, name);
      category = "Premier Elite Buyer";
      discountRate = 0.15;
   }
//methods
/** 
*gets the bonus award points.
*
*@return bonusAwardPoints int
*/
   public int getBonusAwardPoints() {
      return bonusAwardPoints;
   }
/** 
*sets the bonus award points.
*
*@param bonusAwardPointsIn int
*/
   public void setBonusAwardPoints(int bonusAwardPointsIn) {
      bonusAwardPoints = bonusAwardPointsIn;
   }
/**
*overrides the previous calculate award points method but takes
*into account bonus points.
*
*@return awardPoints int
*/
   public int calcAwardPoints() {
      double subtotal = calcSubtotal();
      int awardPoints = (int) subtotal * 20;
      if (calcSubtotal() > 500) {
         awardPoints += bonusAwardPoints;
      }
      return awardPoints;
   }
/**
*overrides the previous toString method.
*
*@return result String
*/
   public String toString() {
      DecimalFormat dF = new DecimalFormat("#,##0.00");
      String subtotal = dF.format(calcSubtotal());
      String tax = dF.format(calcTotal() - calcSubtotal());
      String total = dF.format(calcTotal());
      String result = category + "\nAcctNo/Name: " + acctNumber + " "
         + name + "\nSubtotal: $" + subtotal + "\nTax: $" + tax + "\nTotal: $"
         + total + "\nAward Points: " + calcAwardPoints() + "\n(includes " 
         + discountRate + " discount rate applied to Subtotal)\n(includes " 
         + bonusAwardPoints + " bonus points added to Award Points)";
      return result;
   }
}
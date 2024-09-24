import java.text.DecimalFormat;
 /** 
 *practice with inheritance and using different classes.
 *
 *Project 8 -- part c
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/06/2023
 */
public class EliteBuyer extends Buyer {
//instance variables
   protected double discountRate = 0.05;
//constructor
/**
*inherits all Strings from Buyer's fields and sets category.
*
*@param acctNumber string
*@param name string
*/
   public EliteBuyer(String acctNumber, String name) {
      super(acctNumber, name);
      category = "Elite Buyer";
   }
//methods
/**
*gets the discount rate.
*
*@return discountRate double
*/
   public double getDiscountRate() {
      return discountRate;
   }
/**
*sets the discount rate.
*
*@param discountRateIn double
*/
   public void setDiscountRate(double discountRateIn) {
      discountRate = discountRateIn;
   }
/**
*overrides the calcAwardPoints method from Buyer.
*
*@return awardPoints int
*/
   public int calcAwardPoints() {
      double subtotal = calcSubtotal();
      int awardPoints = (int) subtotal * 10;
      return awardPoints;
   }
/**
*overrides the inherited calcSubtotal method to include discount.
*
*@return subtotal double
*/
   public double calcSubtotal() {
      double subtotal = 0;
      for (int i = 0; i < purchases.length; i++) {
         subtotal += purchases[i]; 
      }
      double discountAmnt = subtotal * discountRate;
      subtotal -= discountAmnt;
      return subtotal;
   }
/**
*overrides the inherited toString method to include discount.
*
*@return result string
*/
   public String toString() {
      DecimalFormat dF = new DecimalFormat("#,##0.00");
      String subtotal = dF.format(calcSubtotal());
      String tax = dF.format(calcTotal() - calcSubtotal());
      String total = dF.format(calcTotal());
      String result = category + "\nAcctNo/Name: " + acctNumber + " "
         + name + "\nSubtotal: $" + subtotal + "\nTax: $" + tax + "\nTotal: $"
         + total + "\nAward Points: " + calcAwardPoints() + "\n(includes " 
         + discountRate + " discount rate applied to Subtotal)";
      return result;
   }
}
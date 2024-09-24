import java.util.Arrays;
import java.text.DecimalFormat;
 /** 
 *practice with inheritance and using different classes.
 *
 *Project 8 -- part a
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/06/2023
 */
public abstract class Buyer {
//instance variables
   protected String category;
   protected String acctNumber;
   protected String name;
   protected double[] purchases;
/**
*constant for the sales tax rate.
*/
   public static final double SALES_TAX_RATE = 0.08;
//constructor
/**
*assigns the above fields and creates array.
*
*@param acctNumberIn string
*@param nameIn string
*/
   public Buyer(String acctNumberIn, String nameIn) {
      acctNumber = acctNumberIn;
      name = nameIn;
      purchases = new double[0];
   }
//methods
/**
*getter for AcctNumber.
*
*@return acctNumber string
*/
   public String getAcctNumber() {
      return acctNumber;
   }
/**
*setter for AcctNumber.
*
*@param acctNumberIn string
*/
   public void setAcctNumber(String acctNumberIn) {
      acctNumber = acctNumberIn;
   }
/**
*getter for Name.
*
*@return name string
*/
   public String getName() {
      return name;
   }
/**
*setter for Name.
*
*@param nameIn string
*/
   public void setName(String nameIn) {
      name = nameIn;
   }
/**
*getter for Purchases.
*
*@return purchases double array
*/
   public double[] getPurchases() {
      return purchases;
   }
/**
*setter for Purchases.
*
*@param purchasesIn array double
*/
   public void setPurchases(double[] purchasesIn) {
      purchases = purchasesIn;
   }
/**
*adds purchases to array list.
*
*@param newPurchases variable length list
*/
   public void addPurchases(double... newPurchases) {
      for (int i = 0; i < newPurchases.length; i++) {
         purchases = Arrays.copyOf(purchases, purchases.length + 1);
         purchases[purchases.length - 1] = newPurchases[i];
      }
   }
/**
*finds and deletes a list from the purchases array.
*
*@param deletePurchases array list
*/
   public void deletePurchases(double... deletePurchases) {
      for (int i = 0; i < purchases.length; i++) {
         for (int j = i; j < deletePurchases.length; j++) {
            if (purchases[i] == deletePurchases[i]) {
               for (int k = i; k < purchases.length - 1; k++) {
                  purchases[k] = purchases[k + 1];
               } 
               purchases = Arrays.copyOf(purchases, purchases.length - 1);
            }
         }
      }
   }
/**
*adds together all of the purchases in an array before tax.
*
*@return subtotal double
*/
   public double calcSubtotal() {
      double subtotal = 0;
      for (int i = 0; i < purchases.length; i++) {
         subtotal += purchases[i]; 
      }
      return subtotal;
   }
/** 
*adds together all of the purchases in an array with tax.
*
*@return total double
*/
   public double calcTotal() { 
      double total = (calcSubtotal() * SALES_TAX_RATE) + calcSubtotal();
      return total;
   }
/**
*calculates the total award points based off subtotal.
*
*@return awardPoints int
*/
   public abstract int calcAwardPoints();
/**
*formats the string that will output.
*
*@return result
*/
   public String toString() {
      DecimalFormat dF = new DecimalFormat("#,##0.00");
      String subtotal = dF.format(calcSubtotal());
      String tax = dF.format(calcTotal() - calcSubtotal());
      String total = dF.format(calcTotal());
      String result = category + "\nAcctNo/Name: " + acctNumber + " "
         + name + "\nSubtotal: $" + subtotal + "\nTax: $" + tax + "\nTotal: $"
         + total + "\nAward Points: " + (int) calcSubtotal();
      return result;
   }
}

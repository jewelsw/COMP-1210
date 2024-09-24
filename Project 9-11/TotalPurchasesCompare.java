
import java.util.Comparator;
/** 
 *practice with inheritance and polymorphism.
 *
 *Project 10 -- part g
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/12/2023
 */
public class TotalPurchasesCompare implements Comparator<Buyer> {
/**
*compares each total and orders them based on it.
*
*@param buyer1 buyer
*@param buyer2 buyer
*@return 0 for placement
*/
   public int compare(Buyer buyer1, Buyer buyer2) {
      double totalPurchases1 = buyer1.calcTotal();
      double totalPurchases2 = buyer2.calcTotal();
   
      if (totalPurchases1 < totalPurchases2) {
         return 1;
      } else if (totalPurchases1 > totalPurchases2) {
         return -1;
      } else {
         return 0;
      }
   }
}
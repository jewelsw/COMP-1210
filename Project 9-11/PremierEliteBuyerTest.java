import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** 
 *testing the PremierEliteBuyer class.
 *
 *Project 8 -- TEST
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/06/2023
 */
public class PremierEliteBuyerTest {
   private PremierEliteBuyer pEB1 = new PremierEliteBuyer("1001", "Smith, Sam");
   private PremierEliteBuyer pEB2 = new PremierEliteBuyer("1002", "Lane, Jane");

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
/**
*test for Premier Elite Buyer class: getBonusAwardPoints
*and setBonusAwardPoints methods.
*/
   @Test public void getSetBonusAwardPointsTest() {
      Assert.assertEquals(1000, pEB1.getBonusAwardPoints());
   
      pEB2.setBonusAwardPoints(2000);
      Assert.assertEquals(2000, pEB2.getBonusAwardPoints());
   }
/**
*test for Premier Elite Buyer class: calcAwardPoints.
*/
   @Test public void calcAwardPointsTest() {
      pEB1.addPurchases(34.5, 100.0, 63.3, 350.0);
      Assert.assertEquals(9300, pEB1.calcAwardPoints());
      
      pEB2.addPurchases(1000.00);
      Assert.assertEquals(18000, pEB2.calcAwardPoints());
   }
/**
*test for Premier Elite Buyer class: toString.
*/
   @Test public void toStringTest() {
      pEB1.addPurchases(34.5, 100.0, 63.3, 350.0);
      String result = "Premier Elite Buyer\nAcctNo/Name: 1001 Smith, Sam\n"
         + "Subtotal: $465.63\nTax: $37.25\nTotal: $502.88\nAward Points: "
         + "9300\n(includes 0.15 discount rate applied to Subtotal)"
         + "\n(includes 1000 bonus points added to Award Points)";
      Assert.assertEquals(result, pEB1.toString());
   }
}

import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


   /** 
 *testing the EliteBuyer class.
 *
 *Project 8 -- TEST
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/06/2023
 */
public class EliteBuyerTest {
   private EliteBuyer eB1 = new EliteBuyer("1001", "Smith, Sam");
   private EliteBuyer eB2 = new EliteBuyer("1002", "Lane, Jane");

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
/**
*Elite Buyer Test: getDiscountRate and setDiscountRate.
*/
   @Test public void getSetDiscountRateTest() {
      Assert.assertEquals(0.05, eB1.getDiscountRate(), 0.01);
   
      eB2.setDiscountRate(0.09);
      Assert.assertEquals(0.09, eB2.getDiscountRate(), 0.01);
   }
/**
*Elite Buyer Test: calcAwardPoints.
*/
   @Test public void calcAwardPointsTest() {
      eB1.addPurchases(34.5, 100.0, 63.3, 350.0);
      Assert.assertEquals(5200, eB1.calcAwardPoints());
   }
/**
*Elite Buyer Test: calcSubtotal.
*/
   @Test public void calcSubtotalTest() {
      eB1.addPurchases(34.5, 100.0, 63.3, 350.0);
      Assert.assertEquals(520.41, eB1.calcSubtotal(), 0.001);
   }
/**
*Elite Buyer Test: toString.
*/
   @Test public void toStringTest() {
      eB1.addPurchases(34.5, 100.0, 63.3, 350.0);
      String result = "Elite Buyer\nAcctNo/Name: 1001 "
         + "Smith, Sam\nSubtotal: $520.41\nTax: $41.63\nTotal: $"
         + "562.04\nAward Points: 5200\n(includes " 
         + "0.05 discount rate applied to Subtotal)";
      Assert.assertEquals(result, eB1.toString());
   }
}

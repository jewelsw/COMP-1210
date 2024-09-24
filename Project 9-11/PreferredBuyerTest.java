import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


   /** 
 *testing the Buyer and PreferredBuyer classes.
 *
 *Project 8 -- TEST
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/06/2023
 */
public class PreferredBuyerTest {
   private PreferredBuyer pB1 = new PreferredBuyer("1001", "Smith, Sam");
   private PreferredBuyer pB2 = new PreferredBuyer("1002", "Lane, Jane");

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
/**
*test for Buyer class: getAcctNumber and setAcctNumber. 
*/
   @Test public void getSetAcctNumberTest() {
      Assert.assertEquals("1001", pB1.getAcctNumber());
   
      pB2.setAcctNumber("1003");
      Assert.assertEquals("1003", pB2.getAcctNumber());
   }
/**
*test for Buyer class: getName and setName.
*/
   @Test public void getSetNameTest() {
      Assert.assertEquals("Smith, Sam", pB1.getName());
   
      pB2.setName("James, Katie");
      Assert.assertEquals("James, Katie", pB2.getName());
   }
/**
*test for Buyer class: getPurchases and setPurchases.
*/
   @Test public void getSetPurchasesTest() {
      double[] pB2array = {10.0, 15.0, 65.5};
   
      pB2.setPurchases(pB2array);
      Assert.assertEquals(pB2array, pB2.getPurchases());
   }
/**
*test for Buyer class: addPurchases.
*/
   @Test public void addPurchasesTest() {
      pB2.addPurchases(34.5, 100.0, 63.50, 350.0);
   }
/**
*test for Buyer class: deletePurchases.
*/
   @Test public void deletePurchasesTest() {
      double[] pB1array = {10.0, 15.0, 65.5, 30.7};
      double[] testArray = {15.0, 30.7};
   
      pB1.setPurchases(pB1array);
      pB1.deletePurchases(10.0, 65.5);
      Assert.assertArrayEquals(testArray, pB1.getPurchases(), 0.001);
   }
/**
*test for Buyer class: calcSubtotal.
*/
   @Test public void calcSubtotalTest() {
      pB1.addPurchases(34.5, 100.0, 63.50, 350.0);
      Assert.assertEquals(548.00, pB1.calcSubtotal(), 0.001);
   }
/**
*test for Buyer class: calcTotal.
*/
   @Test public void calcTotalTest() {
      pB1.addPurchases(34.5, 100.0, 63.50, 350.0);
      Assert.assertEquals(591.84, pB1.calcTotal(), 0.001);
   }
/**
*test for Buyer and Preferred Buyer class: toString.
*/
   @Test public void toStringTest() {
      pB1.addPurchases(34.5, 100.0, 63.50, 350.0);
      String result = "Preferred Buyer\nAcctNo/Name: 1001 Smith, Sam"
         + "\nSubtotal: $548.00\nTax: $43.84\nTotal: $591.84"
         + "\nAward Points: 548";
      Assert.assertEquals(result, pB1.toString());
   }
/**
*test for Preferred Buyer class: calcAwardPoints.
*/
   @Test public void calcAwardPointsTest() {
      pB1.addPurchases(34.5, 100.0, 63.50, 350.0);
      Assert.assertEquals(548, pB1.calcAwardPoints());
   }
}

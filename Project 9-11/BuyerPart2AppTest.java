import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BuyerPart2AppTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   @Test public void mainTest() {
      String[] args1 = {};
      BuyerPart2App.main(args1);
      Assert.assertEquals("File name expected as command line argument."
            + "\nProgram ending.", BuyerPart2App.main(args1));
   }
   
   @Test public void mainTest2() {
      String[] args2 = {"Buyer_data_1.txt"};
      BuyerPart2App.main(args2);
   }
}

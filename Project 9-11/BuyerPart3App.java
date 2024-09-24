import java.io.FileNotFoundException;
 /** 
 *contains the main method for running the program, as well as
 *error handling.
 *
 *Project 11 -- part f
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/26/2023
 */
public class BuyerPart3App {
/**
*main method which handles some exceptions and formats the overall
*printed output.
*
*@param args String[] Command Line Arguments -- file name
*/
   public static void main(String[] args) {
      if (args.length == 0) {
         System.out.println("File name expected as command line argument."
            + "\nProgram ending.");
         return;
      }
   
      String fileName = args[0];
      BuyerProcessor processor = new BuyerProcessor();
   
      try {
         //BuyerProcessor processor = new BuyerProcessor();
         processor.readBuyerFile(fileName);
      
         System.out.println(processor.generateReport());
         System.out.println(processor.generateReportByName());
         System.out.println(processor.generateReportByTotalPurchases());
      } catch (FileNotFoundException e) {
         System.out.println("Attempted to read file: " + fileName 
            + " (No such file or directory)\n Program ending.");
         e.printStackTrace();
      }
      System.out.println(processor.generateInvalidRecordsReport());
   }
}
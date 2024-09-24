import java.io.FileNotFoundException;
 /** 
 *contains the main method for running the program, as well as
 *error handling.
 *
 *Project 10 -- part f
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/12/2023
 */
public class BuyerPart2App {
/**
*main method.
*
*@param args String[] Command Line Arguments -- file name
*/
   public static void main(String[] args) {
      if (args.length == 0) {
         System.out.println("File name expected as command line argument."
            + "\nProgram ending.");
         return;
      }
   
      //String fileName = args[];
   
      try {
         String fileName = args[0];
         BuyerProcessor processor = new BuyerProcessor();
         processor.readBuyerFile(fileName);
      
         System.out.println(processor.generateReport());
         System.out.println(processor.generateReportByName());
         System.out.println(processor.generateReportByTotalPurchases());
      } catch (FileNotFoundException e) {
         String fileName = args[0];
         System.out.println("Attempted to read file: " + fileName 
            + " (No such file or directory)\n Program ending.");
         e.printStackTrace();
      }
   }
}
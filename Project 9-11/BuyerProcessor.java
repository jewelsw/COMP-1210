import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
   /** 
 *practice with inheritance and polymorphism.
 *
 *Project 10 -- part e
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/12/2023
 */
public class BuyerProcessor { 
//fields
   private Buyer[] buyerArray;
   private String[] invalidRecords;
//constructor
/**
*initializes the buyer array and string array in the feilds 
*to length 0.
*/
   public BuyerProcessor() {
      buyerArray = new Buyer[0];
      invalidRecords = new String[0];
   }
//methods
/**
*returns a buyer array representing the buyer array field.
*
*@return buyerElem array
*/
   public Buyer[] getBuyerArray() {
      return buyerArray;
   }
/**
*returns a string array representing the invalid records array
*field.
*
*@return invalidRecords array
*/
   public String[] getInvalidRecordsArray() {
      return invalidRecords;
   }
/**
*increases the capacity of the buyer array by one and adds the 
*buyer in the last position of the buyer array.
*
*@param addObj buyer object
*/
   public void addBuyer(Buyer addObj) {
      //for (int i = 0; i < 1; i++) {
      buyerArray = Arrays.copyOf(buyerArray, buyerArray.length + 1);
      buyerArray[buyerArray.length - 1] = addObj;
      //}
   }
/**
*increases the capacity of he invalidRecords by one and adds the
*string in the last position.
*
*@param addString String
*/
   public void addInvalidRecord(String addString) {
      //for (int i = 0; i < 1; i++) {
      invalidRecords = Arrays.copyOf(invalidRecords, invalidRecords.length + 1);
      invalidRecords[invalidRecords.length - 1] = addString;
      //}
   }
/**
*throws a fileNotFoundException, creates a scanner object to 
*read the file one line at a time and an appopriate Buyer object is
*created and addeed to buyer array field.
*
*@param fileName String
*@throws FileNotFoundException if file does not exist
*/
//public void readBuyerFile(String fileName) throws FileNotFoundException {
//File file = new File(fileName);
//Scanner fileScanner = new Scanner(file);


//}
   public void readBuyerFile(String fileName) throws FileNotFoundException {
      File file = new File(fileName);
      Scanner fileScanner = new Scanner(file);
      
      while (fileScanner.hasNextLine()) {
         String line = fileScanner.nextLine();
         Scanner lineScanner = new Scanner(line);
      
         int category = lineScanner.nextInt();
         String accountNumber = lineScanner.next();
         String lastName = lineScanner.next();
         String firstName = lineScanner.next();
         String name = String.join(", ", lastName, firstName);
         String categoryName = "";
         
         int i = 0; 
         double[] purchases = new double[0];
         while (lineScanner.hasNextDouble()) {
            purchases = Arrays.copyOf(purchases, purchases.length + 1);
            purchases[i] = lineScanner.nextDouble();
            i++;
         }
         
         
         Buyer buyer;
         if (category == 1) {
            buyer = new PreferredBuyer(accountNumber, name);
            categoryName = "Preferred Buyer";
         
         } 
         else if (category == 2) {
            buyer = new EliteBuyer(accountNumber, name);
            categoryName = "Elite Buyer";
         } 
         else if (category == 3) {
            buyer = new PremierEliteBuyer(accountNumber, name);
            categoryName = "Premier Elite Buyer";
         }
         else {
            throw new IllegalArgumentException("Invalid category code: " 
                  + category);
         }
         
         buyer.category = categoryName;
         buyer.acctNumber = accountNumber;
         buyer.name = name;
         buyer.purchases = purchases;
         
         addBuyer(buyer);
         
         lineScanner.close();
      }
      fileScanner.close();
      
   }
/**
*processes the buyer array using the original order to produce the report
*no sorting.
*
*@return report String
*/
   public String generateReport() {
      StringBuilder report = new StringBuilder();
   
      report.append("--------------------------------------\n"
         + "Buyer Report\n--------------------------------------\n");
         
      for (Buyer buyer : buyerArray) {
         report.append(buyer.toString());
         report.append("\n\n");
      }
      
      return report.toString();
   }
/**
*sorts the buyer array by its natural ordering and processes the buyer array
*by its natural ordering and produces report by name.
*
*@return reportByName String
*/
   public String generateReportByName() {
      Arrays.sort(buyerArray, 
         new Comparator<Buyer>() {
            public int compare(Buyer buyer1, Buyer buyer2) {
               return buyer1.getName().compareTo(buyer2.getName());
            }
         });
         
      StringBuilder reportByName = new StringBuilder();
   
      reportByName.append("---------------------------------------\n"
         + "Buyer Report by Name\n---------------------------------------\n");
      for (Buyer buyer : buyerArray) {
         reportByName.append(buyer.toString());
         reportByName.append("\n\n");
      }
      return reportByName.toString();
   }
/**
*sorts the buyer array by its total purchases and processes produces report.
*
*@return reportByPurchases String
*/  
   public String generateReportByTotalPurchases() {
      Arrays.sort(buyerArray, new TotalPurchasesCompare());
   
      StringBuilder reportByPurchases = new StringBuilder();
   
      reportByPurchases.append("---------------------------------------\n"
         + "Buyer Report by Total Purchases"
         + "\n---------------------------------------\n");
      for (Buyer buyer : buyerArray) {
         reportByPurchases.append(buyer.toString());
         reportByPurchases.append("\n\n");
      }
      
      return reportByPurchases.toString();
   }
}
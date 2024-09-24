 /** 
 *declares a new Exception called InvalidCategoryException
 *as a part of the Exception class.
 *
 *Project 11 -- part g
 *@author Jewels Wolter - COMP 1210 - group 4 section 001
 *@version 04/26/2023
 */
public class InvalidCategoryException extends Exception {
/**
*constructor for the class, which inherits from Exception, 
*returns nothing.
*
*@param category String
*/
   public InvalidCategoryException(String category) {
      super("For category: " + "\"" + category + "\"");
   }
}
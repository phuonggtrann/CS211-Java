/**
 * A class which maintains basic information about an academic course. 
 * @author CS211 GMU
 */

public class Course {
  
/**
 * Attributes.
 */
  private String code;
  private String title;
  private String dept; // name of department offering the course
  private int credits;

/**
 * Constructor.
 */
  public Course(String code,  String title, int credits) {
     // TODO : initilize instance variables, use the static method defined in  
    // Registrar to initialize the dept name variable
    
 
    }

/**
 * Accessor methods.
 */
// TODO: define a setter and a getter method for each of the instance variables

/**
 * public methods.
 */
 @Override
 public String toString() { 
   // TODO: implement so that a string is returned in the following format:
   //  "\tINFS 612 Communication Systems (3)”

 }
 
 public String fullString() {
   // TODO: implement so that a string is returned in the following format:  
   //"\tINFS 612 Communication Systems (3) credit hours”
   
 }

}

/*
 * A class which maintains basic information about an academic course. 
 * @author CS211 GMU
 */

public class Course {
  
/**
 * Attributes.
 */
  private String code; //this refer to the course code: MATh 101, PHYS 101
  private String title; //this refer to full title of the course: Linear Algrebra, Univeristy Physics
  private String dept; // name of department offering the course
  private int credits;

/**
 * Constructor.
 */
  public Course(String code,  String title, int credits) {
     // TODO : initilize instance variables, use the static method defined in  
    // Registrar to initialize the dept name variable
    this.code=code;
    this.title=title;
    this.credits=credits;
    this.dept=Registrar.getDeptName(this.code);   // call in static method for this instance
    }

/**
 * Accessor methods.
 */
// TODO: define a setter and a getter method for each of the instance variables

// getter and setter for instance
public String getCode() {return this.code;}
public void setCode(String code) {this.code=code;}

public String getTitle() {return this.title;}
public void setTitle(String title) {this.title=title;}

public int getCredits() {return this.credits;}
public void setCredits(int credits) {this.credits=credits;}

public String getDept() {return this.dept;}
public void setDept(String code) {this.dept=Registrar.getDeptName(code);}

 @Override
 public String toString() { 
   // TODO: implement so that a string is returned in the following format:
   //  "INFS 612 Communication Systems (3)�
   return String.format("%s %s", this.code, this.title); // Using string format to return appropriate string
   }
 
 public String fullString() {
   // TODO: implement so that a string is returned in the following format:  
   //"INFS 612 Communication Systems (3) credit hours�
   return String.format("%s %s, (%d) credit hours.", this.code, this.title, this.credits);
 } // Same as above but different string format style

}

import sun.jvm.hotspot.code.CodeBlob;

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
    this.title=title;
    this.credits=credits;
    this.code=code;
    this.dept=Registrar.getDeptName(this.code);
    }

/**
 * Accessor methods.
 */
// TODO: define a setter and a getter method for each of the instance variables
    public String getTitle() {return title;}
    public Course setTitle(String title) {
      this.title=title;
      return this;} 
    //public String getTitle(){return this.tittle}
    //public void setTitle(String title) {this.title=title}
    
    public int getCredits() {return credits;}
    public Course setCredits(int credits) {
      this.credits=credits;
      return this;
    }

    public String getCode() {return code;}
    public Course setCode(String code) {
      this.code=code;
      return this;
    }

    public String getDept() {return dept;}
    public Course setDept(String code) {
      this.dept = Registrar.getDeptName(code);
      return this;
    }
/**
 * public methods.
 */
 @Override
 public String toString() { 
   // TODO: implement so that a string is returned in the following format:
   //  "\tINFS 612 Communication Systems (3)�
  return String.format("\t%s %s %s (%d)", code,title,dept,credits);
 }
 
 public String fullString() {
   // TODO: implement so that a string is returned in the following format:  
   //"\tINFS 612 Communication Systems (3) credit hours�
   return toString()+ " credit hours";
 }

}

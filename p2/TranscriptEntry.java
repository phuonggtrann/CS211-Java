/**
 * A sub-class which extends the Course class to keep track of a student 
 * registration in a course, and also perform 
 * @author CS211 GMU
 */
public class TranscriptEntry extends Course {
/**
 * Attributes
 * 
 */
  private String semester;
  private int year;
  private String grade;
  private boolean active;
  private Course c;
  
  public TranscriptEntry(Course c, String semester, int year) {
    // TODO
    // note: active must be initialized to true.
    super(c);
    this.semester=semester;
    this.year=year;
    this.grade="";
    this.active= true;
    this.c=c;
  }     
  
/**
 * Accessor methods methods.
 * // TODO
 * define a setter and a getter for each instance variable.
 * note: Do not write accessor methods for the active variable since its an internal variable:
 *       if a course is flagged active, then the student is currently enrolled in that course.
 *       When a grade is posted for a course, active is set to false.
 */
  
  
  /**
   * Public Mathods.
   * 
   */
  
  public boolean isActive() {
   //TODO
  }
 
  
 @Override
 public String toString() { 
   // return a string with the following format:
   //  "\tINFS 510 Database Systems,   credits: 3, GRADE: A" 
   //TODO
 }
}
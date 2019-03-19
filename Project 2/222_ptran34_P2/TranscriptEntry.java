/**
 * A sub-class which extends the Course class to keep track of a student 
 * registration in a course, and also perform 
 * @author CS211 GMU
 */
public class TranscriptEntry extends Course {
// Declare attributes
  private String semester;
  private int year;
  private String grade;
  private boolean active;
  private Course c;
  
  public TranscriptEntry(Course c, String semester, int year) {
    // TODO
    // note: active must be initialized to true.
    // Initialize attributes
    super(c.getCode(),c.getTitle(),c.getCredits()); // since this is a child class, we call super() to acces parents' function
    this.c=c;
    this.semester=semester;
    this.year=year;
    this.grade="";
    this.active=true; // active must be true


  }     
  
/**
 * Accessor methods methods.
 * // TODO
 * define a setter and a getter for each instance variable.
 * note: Do not write accessor methods for the active variable since its an internal variable:
 *       if a course is flagged active, then the student is currently enrolled in that course.
 *       When a grade is posted for a course, active is set to false.
 */

 // Setter and getter method for attributes
public Course getC() {return this.c;}
public void setC(Course c) {this.c=c;}

public String getSemester() {return this.semester;}
public void setSemester(String semester) {this.semester=semester;}

public int getYear() {return this.year;}
public void setYear(int year) {this.year=year;}

public String getGrade() {return this.grade;}
public void setGrade(String grade) {this.grade=grade;}
  
  /**
   * Public Mathods.
   * 
   */
  
public boolean isActive() {
  //TODO
  if (getGrade().equals("")) { // if no grade is posted then isActive() is true
    this.active=true;
  }
  else { // if grade has posted then isActive become false
    this.active=false;
  }
  return this.active;
  }
 
 @Override
 public String toString() { 
   // return a string with the following format:
   //  "\tINFS 510 Database Systems,   credits: 3, GRADE: A" (for students have assigned grade)
   //  "\tINFS 510 Database Systems,   credits: 3" (for student who doesnt have an assigned grade)
   //TODO
   // If no grade is posted, toString has different format therefore if-else is used
   if (this.grade.equals("")) { 
     return String.format("\t%s %s,   credits: %d", super.getCode(),super.getTitle(),super.getCredits());
    }
   else {
     return String.format("\t%s %s,   credits: %d, GRADE: %s", super.getCode(),super.getTitle(),super.getCredits(),this.getGrade()); 
    }
 }
}
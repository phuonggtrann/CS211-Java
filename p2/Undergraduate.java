
 /**
 * This class extends the Student class to provide specialized behavior.
 */
public class Undergraduate extends Student {
  /**
 * Attributes.
 */
  private String highSchool;


 /**
 * Constructor method.
 */
 public Undergraduate(String first, String last, long gnum, 
                      String major, String degree, String highSchool) {
   // TODO
 }
 

 /**
 * Accessor methods.
 */
 // TODO



 /**
 * The two abstract methods from parent class.
 */
 protected boolean approvedForClass(Course c) {
   /* an undergraduate is allowed to register if this course belongs to his major, or he has already 
    * registered to 2 courses (6.0 credits) of his major in the current semester.
    */
   // TODO
 }
    
  protected void setCourseGrade(TranscriptEntry entry, int score) {
  // use the following for grade assignments:
  // if (score >= 98) then the grade is A+, 
  // if (92 <= score < 98) then the grade is A,
  // if (90 <= score < 92) then the grade is A-,
  // if (score >= 88) then the grade is B+, 
  // if (82 <= score < 88) then the grade is B,
  // if (80 <= score < 82) then the grade is B-,
  // if (score >= 78) then the grade is C+, 
  // if (72 <= score < 78) then the grade is C,
  // if (70 <= score < 72) then the grade is C-,
  // if (score >= 60) then the grade is D,
  // if (score < 60) then the grade is F,
    // TODO

  }
  
 @Override
 public String toString() {
  // overrides the toString() method defined in its parent class, returns a String in the following format: 
  //                 �John Smith, Degree: B.S., Major: Computer Science�
  // TODO

 }


}

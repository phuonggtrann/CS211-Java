
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
   super(0, first, last, gnum, major, degree);
   this.highSchool=highSchool;
 }

 /**
 * Accessor methods.
 */
 // TODO
 public String getHighSchool() {return this.highSchool;}
 public void setHighSchool(String highSchool) {this.highSchool=highSchool;}

 /**
 * The two abstract methods from parent class.
 */
 protected boolean approvedForClass(Course c) {
   /* an undergraduate is allowed to register if this course belongs to his major, or he has already 
    * registered to 2 courses (6.0 credits) of his major in the current semester.
    */
   // TODO
   int creditCount=0;
   if (c.getDept().equals(super.getMajor())) {
     return true;
   }
   else {
    for (TranscriptEntry t:this.getTranscripts()) {
      if (t.equals(c)) {
        if (t.isActive() && c.getDept().equals(super.getMajor())) {
          creditCount+=t.getCredits();
        }
      }
    }
      if (creditCount>=6) {return true;}
      else {return false;}
  }
}

    
  protected void setCourseGrade(TranscriptEntry entry, int score) {
  // use the following for grade assignments:
    // if (score >= 98) then the grade is A+, 
    if (score>=98) {
      entry.setGrade("A+");
    } 
    // if (92 <= score < 98) then the grade is A,
    if (score>=92 && score<98) {
      entry.setGrade("A");
    } 
  // if (90 <= score < 92) then the grade is A-,
    if (score>=90 && score<92) {
      entry.setGrade("A-");
    } 
  // if (score >= 88) then the grade is B+,
    if (score>=88 && score<90) {
      entry.setGrade("B+");
    }  
  // if (82 <= score < 88) then the grade is B,
    if (score>=82 && score<88) {
      entry.setGrade("B");
    } 
  // if (80 <= score < 82) then the grade is B-,
    if (score>=80 && score<82) {
      entry.setGrade("B-");
    } 
  // if (score >= 78) then the grade is C+, 
    if (score>=78 && score<80) {
      entry.setGrade("C+");
    } 
  // if (72 <= score < 78) then the grade is C,
    if (score>=72 && score<78) {
      entry.setGrade("C");
    } 
  // if (70 <= score < 72) then the grade is C-,
    if (score>=70 && score<72) {
      entry.setGrade("C-");
    } 
  // if (score >= 60) then the grade is D,
    if (score>=60 && score<70) {
      entry.setGrade("D");
    } 
  // if (score < 60) then the grade is F,
    // TODO
    if (score<60) {
      entry.setGrade("F");
    } 
  }
  
 @Override
 public String toString() {
  // overrides the toString() method defined in its parent class, returns a String in the following format: 
  //                 “Smith, John (G#0000000000), Degree: B.S., Major: Computer Science”
  // TODO
  return String.format("%s, %s (G#%s), Degree:%s, Major: ", this.last, this.first, this.gnum, this.degree, this.major);
 }


}

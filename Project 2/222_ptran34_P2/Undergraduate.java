
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
  
   /// Constructor, initialize attributes
  public Undergraduate(String first, String last, long gnum, String major, String degree, String highSchool) {
    // TODO
    super(0, first, last, gnum, major, degree); // Since this is a subclass, super() is used
    this.highSchool = highSchool; 
  }

  /**
   * Accessor methods.
   */
  // TODO

  // Setter and getters method 

  public String getHighSchool() {
    return this.highSchool;
  }

  public void setHighSchool(String highSchool) {
    this.highSchool = highSchool;
  }

  /**
   * The two abstract methods from parent class.
   */
  protected boolean approvedForClass(Course c) {
    /*
     * an undergraduate is allowed to register if this course belongs to his major,
     * or he has already registered to 2 courses (6.0 credits) of his major in the
     * current semester.
     */
    // TODO
    int creditCount = 0; // is used to count total credits of major course that a student is currently taking
    if (c.getDept().equalsIgnoreCase(this.getMajor())){
      return true; // if "c" is a major class then it's automatically approved
    } else { // if the course isn't a major course then loop throush transcript array
      for (TranscriptEntry t : this.getTranscripts()) { 
        if (t.getDept().equalsIgnoreCase(this.getMajor()) && t.isActive()) { // if that object is a major course and is taken this semester (isActive()=true)
          creditCount += t.getCredits(); // Add it to creditCount
        }
      }
    }
    if (creditCount >= 6) { 
      return true; // non-major course is approved if total major course credits is 6 or more
    } else {
      return false; // if total major credit is less than 6, non-major course is not approved
    }
  }

  protected void setCourseGrade(TranscriptEntry entry, int score) {
    // use the following for grade assignments:
    // if (score >= 98) then the grade is A+,
    if (score >= 98) {
      entry.setGrade("A+");
    }
    // if (92 <= score < 98) then the grade is A,
    if (score >= 92 && score < 98) {
      entry.setGrade("A");
    }
    // if (90 <= score < 92) then the grade is A-,
    if (score >= 90 && score < 92) {
      entry.setGrade("A-");
    }
    // if (score >= 88) then the grade is B+,
    if (score >= 88 && score < 90) {
      entry.setGrade("B+");
    }
    // if (82 <= score < 88) then the grade is B,
    if (score >= 82 && score < 88) {
      entry.setGrade("B");
    }
    // if (80 <= score < 82) then the grade is B-,
    if (score >= 80 && score < 82) {
      entry.setGrade("B-");
    }
    // if (score >= 78) then the grade is C+,
    if (score >= 78 && score < 80) {
      entry.setGrade("C+");
    }
    // if (72 <= score < 78) then the grade is C,
    if (score >= 72 && score < 78) {
      entry.setGrade("C");
    }
    // if (70 <= score < 72) then the grade is C-,
    if (score >= 70 && score < 72) {
      entry.setGrade("C-");
    }
    // if (score >= 60) then the grade is D,
    if (score >= 60 && score < 70) {
      entry.setGrade("D");
    }
    // if (score < 60) then the grade is F,
    // TODO
    if (score < 60) {
      entry.setGrade("F");
    }
  }

  @Override
  public String toString() {
    // overrides the toString() method defined in its parent class, returns a String
    // in the following format:
    // “Smith, John (G#0000000000), Degree: B.S., Major: Computer Science”
    // TODO
    return String.format("%s, %s (G#%s), Degree: %s, Major: %s", this.last, this.first, this.gnum, this.degree,
        this.major); // using String.format and return appropriate string
  }

}

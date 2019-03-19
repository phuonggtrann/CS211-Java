
/**
 * An abstract class for maintaing basic information about a student attending
 * this college. This class defines public methods to provide the following
 * functionality to a student object: - register and drop courses - record a
 * grade for a completed course - get transcripts / a list of completed courses
 * sub-classes of this class will specify how student rgistration is to be
 * performed (depending on the level of the student), and also grade
 * assignments.
 * 
 * @author CS211 GMU
 */

public abstract class Student {
  /**
   * Attributes. note how the class is defining its instance variables as
   * protected so that they are accessible to its sub-classes.
   */
  // Declare attributes
  protected String first, last;
  protected long gnum;
  protected String major;
  protected String degree;
  protected TranscriptEntry[] transcripts; // an array of objects
  protected final int PROGRAM; // a constant which will be initilized to 0 or 1 in the constructor method
  private int count;
  private int max;

  /**
   * Attributes. note how the class is defining its instance variables as
   * protected so that they are accessible to its sub-classes.
   */

   // Constructor, initialize attributes
  public Student(int level, String first, String last, long gnum, String major, String degree) {
    // TODO initialize the instance variables
    // Also use the parameter variable "level" as follows
    // 1) use its value to initialized the PROGRAM constant
    // 2) create the transcripts array to be of size [50] if is level 0,
    // or to be of size [15] if level is 1.
    // note that level refers to the student type and we use a value of 0 for
    // an undergrad and a value of 1 for a grad
    this.first = first;
    this.last = last;
    this.gnum = gnum;
    this.major = major;
    this.degree = degree;
    this.PROGRAM = level;
    // Declare TranscriptEntry array of 0 length, getter will take care of the length
    this.transcripts = new TranscriptEntry[0]; 
  }

  /**
   * Accessor methods.
   */
  // TODO: define a setter and a getter method for each of the instance variables
  public String getFirst() {
    return this.first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public String getLast() {
    return this.last;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public int getProgram() {
    return this.PROGRAM;
  }
  // final instance doesn't have setter

  public long getGnum() {
    return this.gnum;
  }

  public void setGnum(long gnum) {
    this.gnum = gnum;
  }

  public String getMajor() {
    return this.major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getDegree() {
    return this.degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public TranscriptEntry[] getTranscripts() {
    return this.transcripts;
  }
  // initialize transcript array depend on the level
  public void setTranscipts(int level) {
    if (level == 0) { // level=0 aka undergrad -> length=50
      this.transcripts = new TranscriptEntry[50];
    } 
    else { // level=1 aka grad -> length=15
      this.transcripts = new TranscriptEntry[15];
    }
  }

  /**
   * Public methods.
   */
  public boolean registerAClass(Course c, String semester, int year) {
    // this method will call the approvedForClass method defined by
    // the subclasses before enrolling the student into the course.
    // This method also checks if the student is already enrolled in
    // in the current semester and will return false if thats the case.
    // hint: a student would be currently enrolled if the .isActive() method
    // returned true.

    // Declare and initialize
    boolean canAdd = true; 
    int count=0;
    if (approvedForClass(c)) { // Invoke approvedForClass(Course obj) to check whether a student is eligible to take that course
      for (TranscriptEntry t : this.transcripts) { // search through the transcript array
        if (t.getCode().equalsIgnoreCase(c.getCode())) {
          count++; // keep track of how many times the course has been taken
          if (t.isActive()) { // Can re-register a course
            canAdd = false; // set canAdd to false
            break;
          }
          else {canAdd=true; break;} // Student can retake a course if that course is currently inactive
        }
      }
      if (count==0) {canAdd=true;} // if that course hasn't been take before and the course is approved, canAdd=true;
    } 
    else {
      canAdd = false; // If the course is not approved, canAdd = false
    }
    if (canAdd) { // If a student can register a new course (canAdd=true)
      // Resize the array by creating a new array with bigger length (length+1) and loop through to append elements in
      TranscriptEntry[] temp = new TranscriptEntry[this.transcripts.length + 1];
      for (int z = 0; z < this.transcripts.length; z++) {
        temp[z] = this.transcripts[z];
      }
      // Create TrancsriptEntry object and append new course that can be registered
      TranscriptEntry add = new TranscriptEntry(c, semester, year);
      temp[temp.length - 1] = add; 
      this.transcripts = temp; // Assigned this.transcripts to new created array
    }
  return canAdd; // return boolean
  }


  public boolean dropAClass(String courseCode) {
  // We may only drop a student if he/she is currently enrolled (ie no grade posted yet).
  // Find the course entry in transcripts array and literally remove it, don't just
  // replace it with a null value, shift array elementsleft-ward to replace it!
  // hint: create a new array when removing a course from the transcripts array
       //TODO
    /// Declare and initialize variable
    boolean canDrop = false;
    TranscriptEntry classDrop = null;
    for (TranscriptEntry t : this.transcripts) {
      // The course can be dropped if student is currently taking it (object is in transcript and currently active)
      if ((t.getCode()).equalsIgnoreCase(courseCode) && t.isActive()) {
          canDrop = true;
          classDrop = t;
          break;
      }
    }
    // the code below is the same as registerAClass. However, the resize is different and "classDrop" object is not being appended in
    if (canDrop) {
      TranscriptEntry[] temp = new TranscriptEntry[this.transcripts.length-1];
      int a = 0;
      for (int x = 0; x < this.transcripts.length; x++) {
        if (this.transcripts[x].equals(classDrop)) {  
          continue;
        } else {
          temp[a] = this.transcripts[x];
          a++;
        }
      }
      this.transcripts = temp;
    }
    return canDrop; // return boolean
  }

  public boolean obtainAGrade(String courseCode, int score) {
    // this method will search the transcripts array to find a course and will
    // then assigne a letter grade for the student in that course. if the course is
    // not found
    // in the array, or if its a past course then return false (should overwrite a
    // past course grade).
    // TODO
    // Declare and initialize
    boolean obtainGrade=false;
    for (TranscriptEntry t : this.transcripts) {
      if (t.getCode().equalsIgnoreCase(courseCode)) { // if the course is in transcript
        if (t.isActive()) { // and the course has to be active
          obtainGrade=true; // obtainGrade is true if course is active and in transcript
          setCourseGrade(t, score); } // Invoke setCourseGrade method to assign grade
        else {
          obtainGrade=false; }
      }
    }
    return obtainGrade; // return boolean
  }

  public String getClassList(String semester, int year) {
    String str = String.format(" %s %d\n", semester, year);
    for (TranscriptEntry en : transcripts) {
      if (en == null)
        break;
      else if ((en.getSemester().equalsIgnoreCase(semester)) && (en.getYear() == year))
        str += en.toString() + "\n";
    }
    return str;
  }

  @Override
  public boolean equals(Object o) {
    // two student onjects are equal if they have the same G#
    // TODO
    if (o instanceof Student) {
      Student a = (Student) o; // making o a Student object
      if (this.gnum == a.getGnum()) { // compare their gnum
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    // return a string with the following format:
    // �Smith, John (G#0000000000)�
    // TODO
    return String.format("%s, %s (G#%s)", this.last, this.first, this.gnum);
  } // Use string.format and return appropriate String

  /**
   * Private methods. you may add as much helper methods as you need.
   * 
   */

  protected abstract boolean approvedForClass(Course c);

  protected abstract void setCourseGrade(TranscriptEntry entry, int score);
}

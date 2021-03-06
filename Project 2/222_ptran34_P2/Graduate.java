


/**
 * TODO : write the class definition for the Graduate class.  This class extends Student and includes **/
 // the following two attribute definitions: 
public class Graduate extends Student {
    private String undergraduateMajor;
    private String undergraduateInstitution;

// the class must define the following public and protected methods:
// Constructor is the same as undergraduate subclass
    public Graduate(String fname, String lname, long gnum, String major, String degree, String undergraduateMajor, String undergraduateInstitution) {
        super(1,fname,lname,gnum,major,degree);
        this.undergraduateMajor=undergraduateMajor;
        this.undergraduateInstitution=undergraduateInstitution;
    }
    
    public String getUndergraduateMajor() {return this.undergraduateMajor;}

    public String getUndergraduateInstitution() {return this.undergraduateInstitution;}

    @Override public String toString() { // Same as undergraduate method toString()
        return String.format("%s, %s (G#%s), Degree: %s, Major: %s", this.last, this.first, this.gnum, this.degree,this.major);
    }
 
    protected boolean approvedForClass(Course c) {
    // A GraduateStudent can only register to a course if either it belongs to the program he majors in,
    // for example if the student majors in Physics, then the course's program must be physics
        boolean isApproved=true;
        // a course is approved for graduate student if and only if it's a major course
        if (c.getDept().equalsIgnoreCase(super.getMajor())) {isApproved=true;}
        else {return isApproved=false;} // If it's not a major course then it's not approved
        return isApproved;
    }

    protected void setCourseGrade(TranscriptEntry entry, int score) {
        // no plus/minus ,, and no D option for a graduate **/
        // if (score >= 90) then the grade is A, 
        if (score>=90) {
            entry.setGrade("A");
        } 
        // if (80=<score<90) then the grade is B, 
        if (score>=80 && score<90) {
            entry.setGrade("B");
        } 
        // if (70=<score<80) then the grade is C, 
        if (score>=70 && score<80) {
            entry.setGrade("C");
        } 
        // if (score < 70) then the grade is F, 
        if (score<70) {
            entry.setGrade("F");
        } 
    }
}








/**
 * TODO : write the class definition for the Graduate class.  This class extends Student and includes **/
 // the following two attribute definitions: 
public class Graduate extends Student {
    private String undergraduateMajor;
    private String undergraduateInstitution;

// the class must define the following public and protected methods:
    public Graduate(String fname, String lname, long gnum, String major, String degree, String undergraduateMajor, String undergraduateInstitution) {
        super(1,fname,lname,gnum,major,degree);
        this.undergraduateMajor=undergraduateMajor;
        this.undergraduateInstitution=undergraduateInstitution;
    }
    
    public String getUndergraduateMajor() {return this.undergraduateMajor;}

    public String getUndergraduateInstitution() {return this.undergraduateInstitution;}

    @Override public String toString() {
        return super.toString();
    }
 *
 *      protected boolean approvedForClass(Course c) 
 *       // A GraduateStudent can only register to a course if either it belongs to the program he majors in,
 *       // for example if the student majors in Physics, then the course's program must be physics
 * 
 *      protected void setCourseGrade(TranscriptEntry entry, int score) 
 *       // no plus/minus ,, and no D option for a graduate **/
}





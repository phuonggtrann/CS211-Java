/**
 * The main class in the student registration program.. 
 * This class defines public methods to provide the following functionality:
 *     - maintains the course catalog.
 *     - registers and drop courses for students
 *     - at the end of semester, post grades
 *    
 * @author CS211 GMU
 */
import java.util.Scanner;

public class Registrar {
  
/**
 * Attributes.
 */
 private Student [] students;
 private int numStudents; // keeps track of the students array size
 private Course [] courseCatalog;
 private int numCourses;  // keeps track of the courseCatalog array size
 private String semester;
 private int year;
 
/**
 * Constructor.
 */
 public Registrar(String semester, int year) {
  // TODO.
  // note: maximum number of students is 100, and maximum number of courses is 50.
  this.semester=semester;
  this.year=year;
  if (numStudents>100) {
    this.students= new Student[100];}
  else {
    this.students= new Student[numStudents];}
  if (numCourses>50) {
    this.courseCatalog=new Course[50];
  }
  else {
    this.courseCatalog= new Course[numCourses];
  }
 }

/**
 * Accessor methods.
 */
 public void setSemester(String semester) { this.semester=semester;}
 public String getSemester() { return semester; }
 
 public void setYear(int year) { this.year=year;}
 public int getYear() { return year; }

 // self-made
 public void setStudents(int numStudents) { this.students = new Student[numStudents];}
 public Student[] getStudents() { return this.students; }

 public void setCourseCatalog(int numCourse) { this.courseCatalog = new Course[numCourse];}

 
/**
 * Public methods.
 */      
 public boolean addCourse(String code, String title, int hours) { 
 // if courseCatalog is full , return false, otherwise, add course to the catalog.
 // TODO
  if (this.courseCatalog.length>=50) {return false;}
  else {
    Course[] temp = new Course[this.courseCatalog.length];
    for (int a=0; a<this.courseCatalog.length;a++) {
      temp[a]=this.courseCatalog[a];
    }  
    temp[temp.length-1]=new Course(code,title,hours);
    this.courseCatalog=temp;
    return true;
  }
  }
 
 public String getCourseCatalog() {
   String str="";
   for (Course c : courseCatalog)
     if (c == null) break;
     else str = str + c.fullString() +"\n";
   return str;
   }
 
 public boolean addStudent(String fname, String lname, long gnum, String major, 
                           String degree, String highSchool) {  
 // if the students array is full, return false.
 // otherwise add the student information to the students arrays
 // TODO
  if (this.students.length>=100) {return false;}
  else {
    Student[] temp = new Student[this.students.length];
    for (int a=0; a<this.students.length; a++) {
      temp[a]=this.students[a];
    }
    temp[temp.length-1]=new Undergraduate(fname, lname, gnum, major, degree, highSchool);
    this.students=temp;
    return true;
    }
  }
 
  public boolean addStudent(String fname, String lname, long gnum, String major, 
                            String degree, String uMajor, String uInstit) {  
    // an overloaded method which does the sam as the other addStudent method
    // TODO
    if (this.students.length>=100) {return false;}
  else {
    Student[] temp = new Student[this.students.length];
    for (int a=0; a<this.students.length; a++) {
      temp[a]=this.students[a];
    }
    temp[temp.length-1]=new Graduate(fname, lname, gnum, major, degree, uMajor, uInstit);
    this.students=temp;
    return true;
    }
  }
 
  public boolean register(long gnum, String courseCode) {
    // first check if the course is offered (by searching courseCatalog array using courseCode), if 
    // the course is not found return false.
    // then find the student object in the students array using their gnum, if no student is found 
    // return false.
    // otherwise register the student in the class and return true.
    // TODO
    for (Course c : this.courseCatalog){
      if (c.getCode().equals(courseCode)) {
        for (Student s : this.students) {
          if (s.getGnum()==gnum) {
            return true;
          }
        } /// didn't register student to class 
      }
    }
    return false;
  }
  
  public boolean drop(long gnum, String courseCode) {
    // Find the student object in the students array using their gnum, if no student is found 
    // return false.  otherwise drop the course for the student.
    // TODO
    for (Student s : this.students) {
      if (s.getGnum()==gnum) {
        s.dropAClass(courseCode);
        return true;
      }
  }
    return false;
}
  
  public boolean postGrade(long gnum, String courseCode, int score) {
    // Find the student object in the students array using their gnum, if no student is found 
    // return false.  otherwise post a course grade for the student.
    // TODO
    for (Student s: students) {
      if (s.getGnum()==gnum) {
        for (TranscriptEntry t: s.getTranscripts()) {
          if (t.getCode()==courseCode) {s.setCourseGrade(t, score);}
          return true;
        }
      }
    }
    return false;
  }
  
  
  public String getProgress(long gnum, String semester, int year) {
    Student s = findStudent(gnum);
    if (s == null) 
        return "Student "+gnum+" not found";
    String str = String.format(" %s\n", s.toString());
    return str+s.getClassList(semester, year);
  }

  public static String getDeptName(String code) {
    // given a course code, this static method will return the name
    // of the academic department to which the course belong
    String dept = (new Scanner(code)).next();
    
    if (dept.equalsIgnoreCase("CS")) 
          return "Computer Science";
    else if (dept.equalsIgnoreCase("INFS"))
          return "Information Systems";
    else if (dept.equalsIgnoreCase("IT")) 
          return "Information Tecchnoloy";
    else if (dept.equalsIgnoreCase("MATH")) 
          return "Mathematics";
    else if (dept.equalsIgnoreCase("PHYS"))
          return "Physics";            
    else return null;
  }
  
  
/**
 * Private methods.
 * you will need few helper methods.
 */ 
  public Student findStudent(long gnum){
    for (Student a: this.students) {
      if (a.getGnum()==gnum) {
        return a;
      }
    }
    return null;
  }
}

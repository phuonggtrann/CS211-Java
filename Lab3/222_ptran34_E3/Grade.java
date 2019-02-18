public class Grade {
    private double grade;
    public Grade() {
        this.grade=100;
    }
    public Grade(double grade) {
        if (grade<0) {
            this.grade=0;
        }
        else {this.grade=grade;}
    }
    public double getGrade() {
        return this.grade;
    }
    public void setGrade(double grade) {
        if (grade>=0) {
            this.grade=grade;
        }
    }
    public String toString() {
        String str="";
        if (this.grade>=90) {str="A";}
        else if (this.grade>=80 && this.grade<90) {str="B";}
        else if (this.grade>=70 && this.grade<80) {str="C";}
        else if (this.grade>=60 && this.grade<70) {str="D";}
        else if (this.grade<60) {str="F";}
        return str;     
    }
}
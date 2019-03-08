import java.util.Scanner;
public class InputSplitter {
    private int totalInt;
    private double totalDouble;
    private String totalStr;
    private Scanner scnr;
    public InputSplitter() {
        this.totalInt=0;
        this.totalDouble=0.0;
        this.totalStr="";
        this.scnr = new Scanner(System.in);
    }
    public void next() {
        if (this.scnr.hasNextInt()) {
            int temp = this.scnr.nextInt();
            this.totalInt+=temp;
            System.out.println("integer: "+temp);
        }
        else if (this.scnr.hasNextDouble()) {
            double temp = this.scnr.nextDouble();
            this.totalDouble+=temp;
            System.out.println("double: " + temp);
        }
        else if (this.scnr.hasNext()) {
            String temp = this.scnr.next();
            this.totalStr+=temp;
            System.out.println("string: " + temp);
        }
    }
    public int getIntTotal() {
        return this.totalInt; 
    }
    public double getDoubleTotal() {
        return this.totalDouble;
    }
    public String getStringTotal() {
        return this.totalStr;
    }
    public String toString() {
        String str="";
        str=String.format("integer: %d double: %s string: %s", this.totalInt ,this.totalDouble, this.totalStr);
        return str;
    }
}
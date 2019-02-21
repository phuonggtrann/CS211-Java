// Week4 - Inheritance
// This is a parents class
public class Shape {
    private final String name="";
    private final double area=0;
    public Shape(String name, double area) {
        this.name = name;
        this.area = area;
    }
    public String getName() {return name;}
    public double getArea() {return area;} 
    //public double getArea() {return 0;}
    public String toString() {return getName() + " with area " +getArea();} //getArea() will choose active one which is child one
    // public String toString() {return getName() + " with area " + super.getArea();}
}
// Need to construc all of the object
// super(). Call first line of constructor
// This is a children class
public class Square extends Shape {
    private final double side=0.0;
    public Square(double side) { 
        super("square", side*side); //super in this case is Square, calling parents constructor
        // If no super line -> java automatically call super() aka calling default constructor
        // super();
        this.side=side;
    }
    // over riding 
    public double getArea() {return side*side;} // Make getArea() in parents return 0, delete argument
}


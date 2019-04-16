// SmartDevice is a DeviceInfo
public class SmartDevice implements DeviceInfo{

    // Instances
    private String name;
    private int id;

    // Constructor
    public SmartDevice(String name) {
        this.name=name;
        this.id=0;
    }
    // Getter and Setter for ID
    public int id() {return this.id;}
    public void setID(int id) {this.id=id;}

    // Getter for name
    public String name() {return this.name;}

    // toString method, return the same string format
    public String toString() {
        return String.format("%s %d",this.name,id());
    }

}
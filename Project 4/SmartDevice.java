public class SmartDevice implements DeviceInfo{

    private String name;
    private int id;

    // Constructor
    public SmartDevice(String name) {
        this.name=name;
        this.id=0;
    }
    public int id() {return this.id;}
    public void setID(int id) {this.id=id;}

    public String name() {return this.name;}
    public String toString() {
        return String.format("%s %d",this.name,id());
    }

}
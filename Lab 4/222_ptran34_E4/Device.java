// declare class Device
public class Device {
    // Initialize all variables as private
    private String name;
    private int id;
    private boolean enabledStatus;
    // build up the constructor method
    public Device(String name, int id) {
        this.name=name;
        this.id=id;
        this.enabledStatus=false;
    }
    // getName() method return the name
    public final String getName() {
        return this.name;
    }
    // getID () method return the id
    public final int getID() {
        return this.id;
    }
    // getCategory() return "generic"
    public String getCategory(){
        return "generic";
    }
    // enable() doesn't have a return but set enabledStatus to true
    public void enable() {
        this.enabledStatus = true;
    }
    // disable() doesn't have a return but set enabledStatus to false
    public void disable() {
        this.enabledStatus = false;
    }
    // return boolean to check if the device is enable/disable
    public boolean isEnabled() {
        return this.enabledStatus;
    }
    // return a string 
    @Override public String toString() {
        return (getCategory() + " "+getID() +", "+getName());
    }
}


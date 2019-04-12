import java.util.ArrayList; // since ArrayList is used
// Controller is a Listener
public class Controller implements Listener<Switch, SwitchState> {
    // instances
    private ArrayList<SmartDevice> sdArr;
    private int ID;
    // constructor
    public Controller() {
        this.sdArr= new ArrayList<>();
        this.ID=0;
    }
    // add new SmartDevice to internal ArrayList
    public int addDevice(SmartDevice sd){
        sd.setID(this.ID); // assign id
        this.ID++; // increment id
        this.sdArr.add(sd); // add obj to SmartDevice Array
        if (sd instanceof SmartSwitch) { //if it's a SmartSwitch
            ((SmartSwitch)sd).addStateListener(this);
        }   // typecast and add it to Listener list
        return this.ID;
    }
    // Get device by given device's id
    public SmartDevice getDevice(int id) {
        SmartDevice sDev=null; // Delcare SmartDevice object
        for (SmartDevice sd: this.sdArr){
            if (sd.id()==id) { // checking if same id
                sDev=sd; // initialize it 
                break; // only want the first value
            }
        }
        return sDev;
    }
    // get device at nth index
    public SmartDevice getDeviceN(int ind) {
        return this.sdArr.get(ind); 
    } // return object at index
    // return size of Array
    public int numDevices() {return this.sdArr.size();}
    // remove device if it;s in the Array
    public boolean removeDevice(SmartDevice sd) {
        boolean devFound=false;
        if (this.sdArr.contains(sd)) { // check if it's in arr
            this.sdArr.remove(sd); // remove it
            devFound=true; // assign boolean to true
            if (sd instanceof SmartSwitch) { // if it's a SW
                ((SmartSwitch)sd).removeStateListener(this);
            }   // also remove it from listener array
        }
        return devFound;
    }
    // remove device given its id
    public boolean removeDevice(int id) {
        if (getDevice(id)!=null) { // if there is a id match
            this.sdArr.remove(getDevice(id)); // remove that obj
            return true; // assign boolean to true
        } // if no device with given id, return false
        else {return false;} 
    }
    // print out formatted String
    public void signal(Switch s, SwitchState ss) {
        System.out.println(String.format("%s %d changed state to %s",s.name(), s.id(), ss.toString()));
    }
    // toString method
    public String toString(){
        String s="";
        for (SmartDevice sd: this.sdArr){
            s+=sd.toString()+"\n";
        }
        return s;
    }
}

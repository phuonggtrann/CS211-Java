import java.util.ArrayList;

public class Controller implements Listener<Switch, SwitchState> {
    
    private ArrayList<SmartDevice> sdArr;
    private int ID;

    public Controller() {
        this.sdArr= new ArrayList<>();
        this.ID=0;
    }

    public int addDevice(SmartDevice sd){
        sd.setID(this.ID);
        this.ID++;
        this.sdArr.add(sd);
        if (sd instanceof SmartDevice) {
            ((SmartSwitch)sd).addStateListener(this);
        }
        return this.ID;
    }

    public SmartDevice getDevice(int id) {
        SmartDevice sDev=null;
        for (SmartDevice sd: this.sdArr){
            if (sd.id()==id) {
                sDev=sd;
                break; // only want the first value
            }
        }
        return sDev;
    }
}

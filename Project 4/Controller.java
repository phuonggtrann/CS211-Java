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
        if (sd instanceof SmartSwitch) {
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

    public SmartDevice getDeviceN(int id) {
        SmartDevice sDev = null;
        sDev=this.sdArr.get(id);
        return sDev;
    }

    public int numDevices() {
        return this.sdArr.size();
    }

    public boolean removeDevice(SmartDevice sd) {
        boolean devFound=false;
        if (this.sdArr.contains(sd)) {
            this.sdArr.remove(sd);
            devFound=true;
            if (sd instanceof SmartSwitch) {
                ((SmartSwitch)sd).removeStateListener(this);
            }
        }
        return devFound;
    }

    public boolean removeDevice(int id) {
        if (getDevice(id)!=null) {
            this.sdArr.remove(getDevice(id));
            return true;
        }
        else {return false;}
    }

    public void signal(Switch s, SwitchState ss) {
        System.out.println(String.format("%s %d changed state to %s",s.name(), s.id(), ss.toString()));
    }

    public String toString(){
        String s="";
        for (SmartDevice sd: this.sdArr){
            s+=sd.toString()+"\n";
        }
        return s;
    }
}

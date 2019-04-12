import Java.util.ArrayList;

public class SmartSwitch extends SmartDevice implements Switch {

    private SwitchState state;
    private ArrayList< Listener<Switch, SwitchState>> listenerList;

    public SmartSwitch(String s) {
        super(s);
        this.state = SwitchState.UNKNOWN;
        this.listenerList = new ArrayList<>();
    }

    public SwitchState getState() {return this.state;}

    // should be call whenever the state change
    private void sendSignal(){
        
    }

    public SwitchState flip() {
        this.state= this.state.flip();
        // FIXME: didn't signal to the listeners 
        return s;
    }
    
    public void change(SwitchState ss) {
        if (!this.state.equals(ss)) {
            this.state = ss;
        }
        // FIXME: didn't signal to the listeners
    }

    public void addStateListener(Listener<Switch,SwitchState> l) {
        this.listenerList.add(l);
    }

    public void removeStateListener(Listener<Switch, SwitchState> l) {
        this.listenerList.remove(l);
    }

    public String toString() {
        return String.format("%s: %s",this.name(), this.state.toString());
    }


}

// Since I use ArrayList -> import it
import java.util.ArrayList;
// SmartSwitch is both SmartDevice and Switch
public class SmartSwitch extends SmartDevice implements Switch {
    // instances
    private SwitchState state;
    private ArrayList< Listener<Switch, SwitchState>> listenerList;
    // constructor
    public SmartSwitch(String s) {
        super(s); // because it's a child class
        this.state = SwitchState.UNKNOWN; // default state is unkown
        this.listenerList = new ArrayList<>(); // Declare ArrayList type Listener, generic also specify
    }
    // Getter for current state
    public SwitchState getState() {return this.state;} 
    // should be call whenever the state change
    private void sendSignal(SwitchState changeState){ // private because this is an internal method
        for (Listener<Switch, SwitchState> l: this.listenerList) { // loop through
            l.signal(this, changeState); // signal everyone in the list
        }
    }
    // method return a SwitchState
    public SwitchState flip() {
        SwitchState oldState = this.state; // store current state
        this.state = this.state.flip(); // update state after flip()
        if (oldState!=this.state) { // Check if the state is changed
            sendSignal(this.state); // call in sendSignal to signal all
        }
        return this.state; 
    }
    // void - doesn't have to return anything
    public void change(SwitchState ss) {
        if (this.state!=ss) { // Check if current state is different from passed in state
            this.state = ss; // if yes, change current state
            sendSignal(ss); // if state changed, call sendSignal()
        }
    }
    // Add to ArrayList
    public void addStateListener(Listener<Switch,SwitchState> l) {
        this.listenerList.add(l);
    }
    // Remove element from ArrayList
    public void removeStateListener(Listener<Switch, SwitchState> l) {
        this.listenerList.remove(l);
    }
    // toString method, return the right string format
    public String toString() {
        return String.format("%s %s: %s",this.name(),this.id(), this.state.toString());
    }


}

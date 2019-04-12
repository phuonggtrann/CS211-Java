import java.util.ArrayList;

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
    private void sendSignal(SwitchState changeState){
        for (Listener<Switch, SwitchState> l: this.listenerList) {
            l.signal(this, changeState);
        }
    }

    public SwitchState flip() {
        SwitchState oldState = this.state;
        this.state = this.state.flip();
        if (oldState!=this.state) {
            sendSignal(this.state);
        }
        return this.state;
    }
    
    public void change(SwitchState ss) {
        if (this.state!=ss) {
            this.state = ss;
            sendSignal(ss);
        }
    }

    public void addStateListener(Listener<Switch,SwitchState> l) {
        this.listenerList.add(l);
    }

    public void removeStateListener(Listener<Switch, SwitchState> l) {
        this.listenerList.remove(l);
    }

    public String toString() {
        return String.format("%s %s: %s",this.name(),this.id(), this.state.toString());
    }


}

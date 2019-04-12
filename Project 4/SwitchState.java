
public enum SwitchState {
    // predefine enum objects
    ON(true, "on"), OFF(false, "off"), UNKNOWN(null, "unknown"), ERROR(null, "error");

    // declare instances
    private Boolean mode;
    private String name;

    // Constructor 
    private SwitchState(Boolean mode, String name) {
        this.mode=mode;
        this.name=name;
    }

    // if ON or OFF, return true or false
    // null otherwise
    public Boolean value() {
        return this.mode;
    }
    // return name of the object (already define byy enum class)
    public String toString() {
        return this.name;
    }

    public SwitchState flip() { 
        // Declare SwitchState object
        SwitchState s = null;
        // Using switch to check for state and flip is needed
        switch (this) {
        case ON: // flip
            s = OFF; 
            break;
        case OFF: // flip
            s = ON;
            break;
        case UNKNOWN: // no flip
            s=UNKNOWN;
            break;
        case ERROR: // no flip
            s=ERROR;
            break;
        }
        return s;
    }
}
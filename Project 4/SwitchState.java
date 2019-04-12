
public enum SwitchState {
    ON(true, "on"), OFF(false, "off"), UNKNOWN(null, "unknown"), ERROR(null, "error");

    private Boolean mode;
    private String name;

    // Constructor 
    private SwitchState(Boolean mode, String name) {
        this.mode=mode;
        this.name=name;
    }

    // if ON or OFF, return true.
    // false otherwise
    public Boolean value() {
        return this.mode;
    }

    public String toString() {
        return this.name;
    }

    public SwitchState flip() {
        SwitchState s = null;
        switch (this) {
        case ON:
            s = OFF;
            break;
        case OFF:
            s = ON;
            break;
        default:
            break;
        }
        return s;
    }
}
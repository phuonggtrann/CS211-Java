public enum SwitchState {
    ON, OFF, UNKNOWN, ERROR;

    // if ON or OFF, return true.
    // false otherwise
    public boolean value() {
        switch (this) {
        case ON:
            return true;
        case OFF:
            return false;
        case UNKNOWN:
            return null;
        case ERROR:
            return null;
        }
    }

    public String toString() {
        return this.toString();
    }

    public SwitchState flip() {
        SwitchState s = null;
        switch (this) {
        case ON:
            s = SwitchState.OFF;
            break;
        case OFF:
            s = SwitchState.ON;
            break;
        case UNKNOWN:
            s = SwitchState.UNKNOWN;
            break;
        case ERROR:
            s = SwitchState.ERROR;
            break;
        }
        return s;
    }
}
// Declare interface which is a Device Info
public interface Switch extends DeviceInfo{
    // Needed methods
    public SwitchState getState();
    public SwitchState flip();
    public void change(SwitchState s);
}
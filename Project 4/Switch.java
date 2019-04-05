public interface Switch extends DeviceInfo{
    public SwitchState getState();
    public SwitchState flip();
    public void change(SwitchState s);
}
/** 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar P4tester        # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  javac -cp .;junit-cs211.jar *.java         # compile everything
 *  java -cp .;junit-cs211.jar P4tester        # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class P4tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("P4tester");
  }
  
  //************* SwitchState ***************
  
  @Test public void switchstate_exists() {
    SwitchState s = SwitchState.ON;
    switch (s) { case ON : case OFF : case UNKNOWN : case ERROR : }
  }

  private SwitchState[] ss_states = 
  {  SwitchState.ON, SwitchState.OFF, SwitchState.UNKNOWN, SwitchState.ERROR };
  private SwitchState[] ss_flips =
  {  SwitchState.OFF, SwitchState.ON, SwitchState.UNKNOWN, SwitchState.ERROR };
  private Boolean[] ss_values =
  {  true, false, null, null };
  private String[] ss_strings =
  { "on", "off", "unknown", "error" };

  @Test public void switchstate_flip() {
    for (int i=0;  i < ss_states.length;  i++) {
      String errMsg = String.format("incorrect result of SwitchState.%s.flip()", ss_states[i].name());
      assertEquals(errMsg, ss_flips[i], ss_states[i].flip());
    }
  }
  @Test public void switchstate_value() {
    for (int i=0;  i < ss_states.length;  i++) {
      String errMsg = String.format("incorrect result of SwitchState.%s.value()", ss_states[i].name());
      assertEquals(errMsg, ss_values[i], ss_states[i].value());
    }
  }
  @Test public void switchstate_tostring() {
    for (int i=0;  i < ss_states.length;  i++) {
      String errMsg = String.format("incorrect result of SwitchState.%s.toString()", ss_states[i].name());
      assertEquals(errMsg, ss_strings[i], ss_states[i].toString());
    }
  }
  
  //*************** DeviceInfo ********************
  
  private class DummyDeviceInfo implements DeviceInfo {
    public String name() { return null; }
    public int id() { return 0; }
  }
  
  @Test public void deviceinfo_exists() {
    DeviceInfo d = new DummyDeviceInfo();
    String s = d.name();
    int id = d.id();
  }

  //*************** Switch ********************
  
  private class DummySwitch implements Switch {
    public String name() { return null; }
    public int id() { return 0; }
    public SwitchState getState() { return null; }
    public SwitchState flip() { return null; }
    public void change(SwitchState newState) {}
  }

  @Test public void switch_exists() {
    Switch s = new DummySwitch();
    SwitchState ss = s.getState();
    ss = s.flip();
    s.change(ss);
  }
  
  @Test public void switch_extends() {
    Object o = new DummySwitch();
    assertTrue("A Switch should be a DeviceInfo", o instanceof DeviceInfo);
  }
  
  //*************** SmartDevice ********************

  @Test public void smartdevice_exists() {
    SmartDevice d = new SmartDevice("test");
    d.setID(0);
    String n = d.name();
    int i = d.id();
    String s = d.toString();
  }
  
  @Test public void smartdevice_extends() {
    Object o = new SmartDevice("test");
    assertTrue("A SmartDevice should be a DeviceInfo", o instanceof DeviceInfo);
  }
  
  @Test public void smartdevice_methods() {
    SmartDevice d = new SmartDevice("test");
    assertEquals("SmartDevice's name() is not correctly initialized", "test", d.name());
    assertEquals("SmartDevice's id() should default to zero", 0, d.id());
    d.setID(100);
    assertEquals("SmartDevice's id() incorrect result after setID()", 100, d.id());
    assertEquals("Incorrect SmartDevice toString()", "test 100", d.toString());
  }    

  //*************** Listener ********************

  private class DummyListener1 implements Listener<Integer,String> {
    public void signal(Integer a, String b) {}
  }
  private class DummyListener2 implements Listener<String,Integer> {
    public void signal(String a, Integer b) {}
  }

  @Test public void listener_exists() {
    Listener<Integer,String> dl1 = new DummyListener1();
    Listener<String,Integer> dl2 = new DummyListener2();
    dl1.signal(null, null);
  }
  
  //*************** SmartSwitch ********************
  
  @Test public void smartswitch_exists() {
    SmartSwitch ss = new SmartSwitch("test");
    SwitchState state = ss.getState();
    state = ss.flip();
    ss.change(state);
    ss.addStateListener(null);
    ss.removeStateListener(null);
  }
  
  @Test public void smartswitch_extends() {
    Object o = new SmartSwitch("test");
    assertTrue("A SmartSwitch should be a SmartDevice", o instanceof SmartDevice);
    assertTrue("A SmartSwitch should be a Switch", o instanceof Switch);
  }
  
  private String[] ss_desc = 
    {  "test 0: on", "test 1: off", "test 2: unknown", "test 3: error" };
  
  @Test(timeout=1000) public void smartswitch_methods() {
    SmartSwitch ss = new SmartSwitch("test");
    assertEquals("SmartSwitch name not correctly initialized", "test", ss.name());
    assertEquals("SmartSwitch state should initially be UNKNOWN", SwitchState.UNKNOWN, ss.getState());

    for (int i=0;  i < ss_states.length;  i++ ) {
      ss.setID(i);
      ss.change(ss_states[i]);
      String errMsg = String.format("incorrect result of SmartSwitch.change()");
      assertEquals(errMsg, ss_states[i], ss.getState());
      errMsg = String.format("incorrect result of SmartSwitch.toString() from state %s", ss_states[i].name());
      assertEquals(errMsg, ss_desc[i], ss.toString());     
      errMsg = String.format("incorrect result of SmartSwitch.flip() from state %s", ss_states[i].name());
      assertEquals(errMsg, ss_flips[i], ss.flip());
      assertEquals(errMsg, ss_flips[i], ss.getState());
    }

  }

  @Test(timeout=1000) public void smartswitch_listeners() {
    SmartSwitch ss = new SmartSwitch("test");
    final String[] result = { "" };
    for (int i = 0;  i < 5;  i++) {
      final int ind = i;
      ss.addStateListener(new Listener<Switch,SwitchState>(){
        public void signal(Switch a, SwitchState b) {
          result[0] += String.format("--> %s/%s [%d]\n", a.name(), b.name(), ind);
        }
      });
    }
    for (int i = 0;  i < ss_states.length;  i++) ss.change(ss_states[i]);
    String expected = "--> test/ON [0]\n--> test/ON [1]\n--> test/ON [2]\n--> test/ON [3]\n--> test/ON [4]\n"+
      "--> test/OFF [0]\n--> test/OFF [1]\n--> test/OFF [2]\n--> test/OFF [3]\n--> test/OFF [4]\n"+
      "--> test/UNKNOWN [0]\n--> test/UNKNOWN [1]\n--> test/UNKNOWN [2]\n--> test/UNKNOWN [3]\n--> test/UNKNOWN [4]\n"+
      "--> test/ERROR [0]\n--> test/ERROR [1]\n--> test/ERROR [2]\n--> test/ERROR [3]\n--> test/ERROR [4]\n";
    assertEquals("failure signalling state changes in SwitchState with multiple listeners", expected, result[0]);
    
    Listener<Switch,SwitchState> temp = new Listener<Switch,SwitchState>() {
        public void signal(Switch a, SwitchState b) {
          result[0] += String.format("OOPS (invalid listener has been called)\n");
        }
    };
    ss.addStateListener(temp);
    ss.removeStateListener(temp);
    result[0] = "";
    expected = "--> test/ON [0]\n--> test/ON [1]\n--> test/ON [2]\n--> test/ON [3]\n--> test/ON [4]\n";
    ss.change(SwitchState.ON);
    assertEquals("failure calling SwitchState's remove listener", expected, result[0]);
  }

  private boolean[] flip_listener = { true, true, false, false };
  private boolean[][] change_listener = { 
    {false, true, true, true},
    {true, false, true, true},
    {true, true, false, true},
    {true, true, true, false},
  };
  
  @Test(timeout=1000) public void smartswitch_statechange() {
    SmartSwitch ss = new SmartSwitch("test");
    final boolean[] result = { false };
    ss.addStateListener(new Listener<Switch,SwitchState>(){
       public void signal(Switch a, SwitchState b) {
         result[0] = true;
       }
    });
    
    String errMsg;
    for (int i = 0;  i < ss_states.length;  i++) {
      for (int j = 0;  j < ss_states.length;  j++) {
        ss.change(ss_states[i]);
        result[0] = false;
        ss.change(ss_states[j]);
        errMsg = String.format("State change from %s to %s resulted in sending signal?", ss_states[i], ss_states[j]);
        assertEquals(errMsg, change_listener[i][j], result[0]);
      }
      
      ss.change(ss_states[i]);
      result[0] = false;
      ss.flip();
      errMsg = String.format("State flip from %s resulted in sending signal?", ss_states[i]);
      assertEquals(errMsg, flip_listener[i], result[0]);
    }
  }

  //*************** Controller ********************

  @Test public void controller_exists() {
    Controller c = new Controller();
  }
  @Test public void controller_extends() {
    Object o = new Controller();
    assertTrue("A Controller should be a Listener", o instanceof Listener);
  }
  
  @Test(timeout=1000) public void controller_devices() {
    Controller c = new Controller();
    SmartDevice[] devices = new SmartDevice[5];
    for (int i = 0;  i < devices.length;  i++) {
      devices[i] = new SmartDevice("test" + i);
      c.addDevice(devices[i]);
      assertEquals("incorrect number of devices after adding devices to controller", (i+1), c.numDevices());
    }
    String expected = "test0 0\ntest1 1\ntest2 2\ntest3 3\ntest4 4\n";
    assertEquals("incorrect Controller toString()", expected, c.toString());
    c.removeDevice(devices[0]);
    expected = "test1 1\ntest2 2\ntest3 3\ntest4 4\n";
    assertEquals("incorrect Controller toString() after removing device by object", expected, c.toString());
    c.removeDevice(2);
    expected = "test1 1\ntest3 3\ntest4 4\n";
    assertEquals("incorrect Controller toString() after removing device by ID", expected, c.toString());
    assertEquals("incorrect Controller numDevices() after removal", 3, c.numDevices());
    for (int i = 0; i < 4; i++) {
      SmartDevice d = devices[i];
      SmartDevice r = c.getDevice(i);
      if (i%2==0) assertEquals("getDevice() should return null if device is not in the list", null, r);
      else assertEquals("incorrect getDevice() for device ID " + i, d, r);
    }
    SmartDevice d = devices[1];
    SmartDevice r = c.getDeviceN(0);
    assertEquals("incorrect getDeviceN() at index 0 of device list ", d, r);
  }
  
  @Test(timeout=1000) public void controller_signalling() {
    Controller c = new Controller();
    SmartSwitch[] devices = new SmartSwitch[5];
    for (int i = 0;  i < devices.length;  i++) {
      devices[i] = new SmartSwitch("test" + i);
      c.addDevice(devices[i]);
    }
    setCapture();
    for (int i = 0; i < 10; i++) {
      SwitchState newState = ss_states[i%4];
      devices[i%5].change(newState);
    }
    String actual = getCapture();
    String expected = "test0 0 changed state to on\n" +
      "test1 1 changed state to off\n" +
      "test3 3 changed state to error\n" +
      "test4 4 changed state to on\n" +
      "test0 0 changed state to off\n" +
      "test1 1 changed state to unknown\n" +
      "test2 2 changed state to error\n" +
      "test3 3 changed state to on\n" +
      "test4 4 changed state to off\n";
      
    assertEquals("Capture signal listening simulation produced an incorrect output", expected, actual);
    unsetCapture();
    
  }
  
  
  /** the lines below are for setting up input/output redirection so that the
    * tests can see what is being set to the screen as well as produce its own
    * pseudo-keyboard input.  No test appear below here. */
  
  static ByteArrayOutputStream localOut, localErr;
  static PrintStream sOut, sErr;

  @BeforeClass public static void setup() throws Exception {
    sOut = System.out;
    sErr = System.err;
  }
  
  @AfterClass public static void cleanup() throws Exception {
    unsetCapture();
  }
  
  private static void setCapture() {
   localOut = new ByteArrayOutputStream();
   localErr = new ByteArrayOutputStream();
   System.setOut(new PrintStream( localOut ) );
   System.setErr(new PrintStream( localErr ) );
  }

  private static String getCapture() {
   return localOut.toString().replaceAll("\\r?\\n", "\n");
  }

  private static void unsetCapture() {
   System.setOut( null );
   System.setOut( sOut );
   System.setErr( null );
   System.setErr( sErr );
  }
  
}
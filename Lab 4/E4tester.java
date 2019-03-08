/** 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar E4tester        # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  javac -cp .;junit-cs211.jar *.java         # compile everything
 *  java -cp .;junit-cs211.jar E4tester        # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class E4tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("E4tester");
  }
  
  @Test public void device_construct() { 
    Device dev = new Device("test device", 10);
    assertEquals("device name improperly reported", "test device", dev.getName());
    assertEquals("device ID improperly reported", 10, dev.getID());
  }
  
  @Test public void disk_construct() { 
    Disk disk = new Disk("test disk", 11, 1024);
    assertEquals("disk name improperly reported", "test disk", disk.getName());
    assertEquals("disk ID improperly reported", 11, disk.getID());
    assertEquals("disk size improperly reported", 1024, disk.getSize());
  }
  
  @Test public void printer_construct() { 
    Printer p = new Printer("test printer", 12);
    assertEquals("printer name improperly reported", "test printer", p.getName());
    assertEquals("printer ID improperly reported", 12, p.getID());
  }
  
  @Test public void test_inheritance() {
    Device d1 = new Disk("",0,0);
    Device d2 = new Printer("",0);
    assertFalse("a disk should not be a printer", d1 instanceof Printer);
    assertFalse("a printer should not be a disk", d2 instanceof Disk);
  }
  
  @Test public void device_methods() {
    Device dev = new Device("dev check", 5);
    assertEquals("incorrect device category", "generic", dev.getCategory());
    assertEquals("incorrect device string", "generic 5, dev check", dev.toString());
    assertFalse("device should begin disabled", dev.isEnabled());
    dev.enable();
    assertTrue("device does not enable properly", dev.isEnabled());
    dev.disable();
    assertFalse("device does not disable properly", dev.isEnabled());
  }
  
  @Test public void disk_methods() {
    Disk disk = new Disk("disk check", 6, 555);
    assertEquals("incorrect device category", "disk", disk.getCategory());
    assertEquals("incorrect device string", "disk 6, disk check (555 bytes)", disk.toString());
    assertEquals("incorrect disk size", 555, disk.getSize());
    assertFalse("device should begin disabled", disk.isEnabled());
    disk.enable();
    assertTrue("device does not enable properly", disk.isEnabled());
    disk.disable();
    assertFalse("device does not disable properly", disk.isEnabled());
  }
  
  @Test public void printer_methods() {
    Printer p = new Printer("print check", 7);
    assertEquals("incorrect device category", "printer", p.getCategory());
    assertEquals("incorrect device string", "printer 7, print check", p.toString());
    assertFalse("device should begin disabled", p.isEnabled());
    assertEquals("device should begin with no jobs", 0, p.numJobs());
    p.submitJob();
    assertEquals("device should not accept jobs while disabled", 0, p.numJobs());
    p.completeJob();
    assertEquals("device should not print jobs while disabled", 0, p.numJobs());
    p.enable();
    assertTrue("device does not enable properly", p.isEnabled());
    for (int i = 0;  i < 5;  i++) {
         assertEquals("incorrect number of jobs after submitting", i, p.numJobs());
         p.submitJob();
    }
    for (int i = 5;  i > 0;  i--) {
         assertEquals("incorrect number of jobs after printing", i, p.numJobs());
         p.completeJob();
    }
    p.completeJob();
    assertEquals("device should not print jobs unless there are available jobs", 0, p.numJobs());
    p.submitJob();
    assertEquals(1, p.numJobs());
    p.disable();
    assertFalse("device does not disable properly", p.isEnabled());
    assertEquals("print jobs should clear when device is disabled", 0, p.numJobs());
    
  }
  
                                        
  
  

}
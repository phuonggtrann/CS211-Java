// Declare class Printer inheritance from parents(Device) class
public class Printer extends Device {
    private int jobNum; // Initialize
    public Printer(String name, int id) {
        super(name, id); // super() get info from parents class
        this.jobNum=0; // declare
    }
    @Override public String getCategory() {
        return "printer"; // @Override category to "printer"
    }
    @Override public void disable() {
        super.disable(); // Disable the device 
        this.jobNum=0; // and set number of jobs to 0
    }
    public void submitJob() {
        if (super.isEnabled()==true) { //Check if the device is enable
            this.jobNum++; //number of job increase by 1
        }
    }
    // return current number of job
    public int numJobs() {
        return this.jobNum;
    }
    //check if there is still job and decrease by 1 to complete 1 job
    public void completeJob() {
        if (this.jobNum >0) {
            this.jobNum--;
        }
    }
 }


// Declare class Disk inheritance from class Device
class Disk extends Device {
    // Initialize variable
    private long size;
    public Disk(String name, int id, long size) {
        super(name, id); // super() for children class to access parents' infomation
        this.size = size; 
    }
    @Override public String getCategory() {
        return "disk"; // @Override category to "disk"
    }
    // return the size of 
    public long getSize() {
        return (this.size);
    }
    // @Override: use super() to acess parents' info and add new size info
    @Override public String toString() {
        return super.toString() + String.format(" (%d bytes)",getSize());
    }
}
 
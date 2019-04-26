public class Contact implements Comparable<Contact> {
    
    // Declare instances
    private String name;
    private String phone;
    private String email;
    
    // Constructor which take in 3 parameters for this class
    public Contact(String name, String email, String phone){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    public String getName() {return this.name;}
    public String getEmail() {return this.email;}
    public String getPhone() {return this.phone;}
    public void setEmail(String email) {this.email = email;}
    public void setPhone(String phone) {this.phone=phone;}

    @Override public String toString() {
        return String.format("%s, email: %s, phone: %s.", this.name, this.email, this.phone);
    }

    @Override public int compareTo(Contact c) {
        String name = this.name.toLowerCase();
        String cName = c.getName().toLowerCase();
        return name.compareTo(cName);
    }
}
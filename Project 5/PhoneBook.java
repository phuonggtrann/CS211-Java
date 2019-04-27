import java.io.*;
import java.util.*;
import java.util.Scanner;

public class PhoneBook implements Iterable<Contact> {

    private HashMap<String, Contact> contactHM;

    public PhoneBook() {
        this.contactHM = new HashMap<String, Contact>();
    }

    public boolean fileToMap(String filename) {
        try {
            Scanner s = new Scanner(new File(filename));
            ArrayList<String> contactList = new ArrayList<String>();
            while (s.hasNextLine()) {
                contactList.add(s.nextLine());
            }
            for (int i = 0; i < contactList.size() - 2; i += 3) {
                Contact c = new Contact(contactList.get(i), contactList.get(i + 1), contactList.get(i + 2));
                this.contactHM.put(contactList.get(i).toLowerCase(), c);
            }
            s.close();
            
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean addContact(String name, String email, String phone) {
        if (this.contactHM.containsKey(name.toLowerCase())) {
            return false;
        } else {
            Contact c = new Contact(name, email, phone);
            this.contactHM.put(name.toLowerCase(), c);
            return true;
        }
    }

    public boolean deleteContact(String name) {
        if (this.contactHM.containsKey(name.toLowerCase())) {
            this.contactHM.remove(name.toLowerCase());
            return true;
        } else {
            return false;
        }
    }

    public Contact getContact(String name) {
        Contact c = null;
        if (this.contactHM.containsKey(name.toLowerCase())) {
            c = this.contactHM.get(name.toLowerCase());
        }
        return c;
    }

    public String getContactInfo(String name) {
        String s = null;
        if (this.contactHM.containsKey(name.toLowerCase())) {
            s = (this.contactHM.get(name.toLowerCase())).toString();
        }
        return s;
    }

    public String getEmail(String name) {
        if (this.contactHM.containsKey(name.toLowerCase())) {
            return String.format("%s: %s", name,this.contactHM.get(name.toLowerCase()).getEmail());
        }
        else {return null;}
    }
    public String getPhone(String name) {
        if (this.contactHM.containsKey(name.toLowerCase())) {
            return String.format("%s: %s", name,this.contactHM.get(name.toLowerCase()).getPhone());
        }
        else {return null;}
    }
    public boolean updateEmail(String name, String email) {
        if (this.contactHM.containsKey(name.toLowerCase())) {
            Contact updatedContact = new Contact(name, email, getPhone(name));
            this.contactHM.put(name.toLowerCase(), updatedContact);
            return true;
        }
        else {return false;}
    }
    public boolean updatePhone(String name, String phone) {
        if (this.contactHM.containsKey(name.toLowerCase())) {
            Contact updatedContact = new Contact(name, getEmail(name), phone);
            this.contactHM.put(name.toLowerCase(), updatedContact);
            return true;
        }
        else {return false;}
    }
    public String getContactList() {
        return PhoneBookUtils.mapToString(this.contactHM);
    }
    public String getSortedContactList() {
        List<Contact> l = new ArrayList<Contact>(this.contactHM.values());
        return PhoneBookUtils.listToSortedList(l);
    }
    public String getSortedContactListAlt(){
        ArrayList<Contact> arrList = new ArrayList<Contact>(this.contactHM.values());
        Contact[] cont = new Contact[arrList.size()];
        cont = arrList.toArray(cont);
        PhoneBookUtils.insertionSort(cont, 0);
        String s = "";
        for (Contact contact : cont) {
            s = s + contact.toString() + "\n";
        }
        return s;
    }
    public String searchContactList(String name) {
        List<Contact> arrList = new ArrayList<Contact>(this.contactHM.values());
        Contact[] contact = new Contact[arrList.size()];
        Contact dummyContact = new Contact(name, "", "");
        return (PhoneBookUtils.binarySearch(contact, 0, contact.length, dummyContact)).toString();
    }

    @Override public Iterator<Contact> iterator() {
        ArrayList<Contact> arrList = new ArrayList<Contact>(this.contactHM.values());
        Collections.sort(arrList);
        Iterator<Contact> iter = arrList.iterator();
        return iter;
    }

}

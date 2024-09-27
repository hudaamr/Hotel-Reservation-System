package Models;

public class Person {
    protected String name;
    protected String contactInfo;

    // Constructor
    public Person(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for contactInfo
    public String getContactInfo() {
        return contactInfo;
    }

    // Setter for contactInfo
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // Method to return basic details
    public String getDetails() {
        return "Name: " + name + ", Contact Info: " + contactInfo;
    }
}

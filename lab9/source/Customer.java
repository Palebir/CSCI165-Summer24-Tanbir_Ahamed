public class Customer extends Person {

    private Date dateJoined;
    private String custID;

    // No-argument constructor
    public Customer() {
        this.dateJoined = new Date();
    }

    // Overloaded constructor with all fields
    public Customer(String firstName, String lastName, String phone, Date dob, Date dateJoined, String custID) {
        super(firstName, lastName, phone, dob);
        this.dateJoined = new Date(dateJoined);
        this.custID = custID;
    }

    // Overloaded constructor with Person, dateJoined, and custID
    public Customer(Person p, Date dateJoined, String custID) {
        super(p);
        this.dateJoined = new Date(dateJoined);
        this.custID = custID;
    }

    // Copy constructor
    public Customer(Customer toCopy) {
        super(toCopy);
        this.dateJoined = new Date(toCopy.dateJoined);
        this.custID = toCopy.custID;
    }

    public Date getDateJoined() {
        return new Date(dateJoined);
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = new Date(dateJoined);
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    @Override
    public String toString() {
        return super.toString() + "\\nDate Joined: " + dateJoined + "\\nCustomer ID: " + custID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Customer other = (Customer) obj;

        if (dateJoined == null) {
            if (other.dateJoined != null) return false;
        } else if (!dateJoined.equals(other.dateJoined)) return false;

        if (custID == null) {
            if (other.custID != null) return false;
        } else if (!custID.equals(other.custID)) return false;

        return true;
    }
}

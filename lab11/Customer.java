package lab;

import java.sql.Date;
import java.util.Objects;

public class Customer extends Person {

    private String custID;

    public Customer(String firstName, String lastName, String phone, Date dob, Date dateJoined, String custID) throws IDNotWellFormedException {
        super(firstName, lastName, phone, dob);
        setCustID(custID);
    }

    public Customer(String firstName, String lastName, String phone, lab.Date date, lab.Date date2, String custID2) {
        //TODO Auto-generated constructor stub
    }

    public Customer(Customer customer) {
        //TODO Auto-generated constructor stub
    }

    public void setCustID(String custID) throws IDNotWellFormedException {
        if (!custID.matches("[A-Za-z]\\d{3}")) {
            throw new IDNotWellFormedException("Customer ID must start with a letter followed by 3 digits. Offending ID: " + custID);
        }
        this.custID = custID;
    }

    public String getCustID() {
        return custID;
    }
}


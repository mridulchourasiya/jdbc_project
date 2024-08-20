package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private int id;
    private int gpmId;
    private String name;
    private String gender;
    private LocalDate dob;
    private String aadhaarNumber;
    private String address;
    private String contactNumber;
    private BigDecimal wageRate;

    // Constructor
    public Employee(int id, int gpmId, String name, String gender, LocalDate dob, String aadhaarNumber,
                    String address, String contactNumber, BigDecimal wageRate) {
        this.id = id;
        this.gpmId = gpmId;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.aadhaarNumber = aadhaarNumber;
        this.address = address;
        this.contactNumber = contactNumber;
        this.wageRate = wageRate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGpmId() {
        return gpmId;
    }

    public void setGpmId(int gpmId) {
        this.gpmId = gpmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public BigDecimal getWageRate() {
        return wageRate;
    }

    public void setWageRate(BigDecimal wageRate) {
        this.wageRate = wageRate;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", gpmId=" + gpmId + ", name=" + name + ", gender=" + gender +
                ", dob=" + dob + ", aadhaarNumber=" + aadhaarNumber + ", address=" + address +
                ", contactNumber=" + contactNumber + ", wageRate=" + wageRate + "]";

    }


}

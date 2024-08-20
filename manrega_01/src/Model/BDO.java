package Model;

import java.time.LocalDateTime;

public class BDO {
    private int Id;
    private String Name;
    private String Email;
    private String Password;
    private String ContactNumber;
    private String Address;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;

    // Default Constructor
    public BDO() {
        super();
        this.Id = 0; // Initialize with default values if needed
        this.Name = "";
        this.Email = "";
        this.Password = "";
        this.ContactNumber = "";
        this.Address = "";
        this.CreatedAt = LocalDateTime.now();
        this.UpdatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }

    // toString Method
    @Override
    public String toString() {
        return "BDO [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", Password=" + Password
                + ", Contact Number=" + ContactNumber + ", Address=" + Address
                + ", CreatedAt=" + CreatedAt + ", UpdatedAt=" + UpdatedAt + "]";
    }
}

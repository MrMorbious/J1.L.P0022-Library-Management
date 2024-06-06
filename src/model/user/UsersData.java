package model.user;

import java.io.Serializable;
import java.time.LocalDate;

public class UsersData implements Serializable {
    private int userId;
    private String name;
    private LocalDate dob;
    private String phoneNumber;
    private String email;
    private boolean active_user;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isActive_user() {
        return active_user;
    }
    public void setActive_user(boolean active_user) {
        this.active_user = active_user;
    }
    public String displayOfUser() {
        return String.format(
                "| %-7s | %-25s | %-15s | %-15s | %-30s | %-12s |" ,
                userId, name, dob, phoneNumber, email , active_user
        );
    }
}
